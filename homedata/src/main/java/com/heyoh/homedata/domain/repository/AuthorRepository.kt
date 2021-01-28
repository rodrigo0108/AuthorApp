package com.heyoh.homedata.domain.repository

import com.heyoh.model.home.Author
import com.heyoh.model.result.Failure
import com.heyoh.model.result.Result

interface AuthorRepository {
    suspend fun getAuthors(): Result<List<Author>,Failure>
}