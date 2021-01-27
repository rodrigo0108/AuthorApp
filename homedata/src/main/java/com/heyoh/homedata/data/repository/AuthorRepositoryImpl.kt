package com.heyoh.homedata.data.repository

import com.heyoh.homedata.data.datastore.AuthorRemoteDataStore
import com.heyoh.homedata.domain.repository.AuthorRepository
import com.heyoh.model.home.Author
import com.heyoh.model.result.Failure
import com.heyoh.model.result.Result

class AuthorRepositoryImpl(
    private val authorRemoteDataStore: AuthorRemoteDataStore
) : AuthorRepository {
    override suspend fun getAuthors(): Result<Author, Failure> {
        return authorRemoteDataStore.getAuthors()
    }
}