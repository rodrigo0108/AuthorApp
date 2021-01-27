package com.heyoh.home

import androidx.lifecycle.ViewModel
import com.heyoh.homedata.domain.usecase.GetAuthorsUseCase

class HomeViewModel(
    private val getAuthorsUseCase: GetAuthorsUseCase
): ViewModel() {

    val getAuthors = "Autores"
}