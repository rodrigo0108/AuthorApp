package com.heyoh.homedata.data.datastore

import com.heyoh.model.home.Author
import com.heyoh.model.result.Failure
import com.heyoh.model.result.Result

interface AuthorRemoteDataStore {
    suspend fun getAuthors(): Result<Author, Failure>
}