package com.heyoh.homedata.data.services

import com.heyoh.homedata.data.api.APIUrl
import com.heyoh.model.home.Author
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET(APIUrl.ALL_AUTHORS)
    suspend fun getAuthors(): Response<List<Author>>
}