package com.heyoh.homedata.domain.usecase

import com.heyoh.homedata.domain.repository.AuthorRepository
import com.heyoh.model.home.Author
import com.heyoh.model.result.Failure
import com.heyoh.model.result.Result

class GetAuthorsUseCase(private val authorRepository: AuthorRepository) {
    suspend operator fun invoke(): Result<Author, Failure> = authorRepository.getAuthors()
}