package com.heyoh.home.module

import com.heyoh.home.HomeViewModel
import com.heyoh.homedata.domain.usecase.GetAuthorsUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single { GetAuthorsUseCase() }
    viewModel { HomeViewModel(get()) }
}