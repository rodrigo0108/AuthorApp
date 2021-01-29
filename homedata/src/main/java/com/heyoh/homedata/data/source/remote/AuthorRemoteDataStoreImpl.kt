package com.heyoh.homedata.data.source.remote

import com.heyoh.homedata.data.datastore.AuthorRemoteDataStore
import com.heyoh.homedata.data.services.HomeService
import com.heyoh.model.home.Author
import com.heyoh.model.result.Failure
import com.heyoh.model.result.Result
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.Exception

class AuthorRemoteDataStoreImpl : AuthorRemoteDataStore {
    override suspend fun getAuthors(): Result<List<Author>, Failure> {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("http://192.168.0.109:5000")
            .client(OkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofitBuilder.create(HomeService::class.java)
        return try {
            val result = service.getAuthors()
                if (result.isSuccessful && result.body()!=null) {
                    Result.Success(result.body()!!)
                } else {
                    Result.Error(Failure.ClientError)
                }
        } catch (ex: Exception) {
            Result.Error(Failure.Unexpected)
        }
    }
}