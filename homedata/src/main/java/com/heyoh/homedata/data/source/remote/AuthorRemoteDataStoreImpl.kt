package com.heyoh.homedata.data.source.remote

import com.heyoh.homedata.data.datastore.AuthorRemoteDataStore
import com.heyoh.model.home.Author
import com.heyoh.model.result.Failure
import com.heyoh.model.result.Result

class AuthorRemoteDataStoreImpl : AuthorRemoteDataStore {
    override suspend fun getAuthors(): Result<Author, Failure> {
        return Result.Success(Author("","Rolando","","",""))
    }
}