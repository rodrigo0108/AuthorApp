package com.heyoh.home.module

import com.heyoh.home.HomeViewModel
import com.heyoh.homedata.data.datastore.AuthorRemoteDataStore
import com.heyoh.homedata.data.repository.AuthorRepositoryImpl
import com.heyoh.homedata.data.source.remote.AuthorRemoteDataStoreImpl
import com.heyoh.homedata.domain.repository.AuthorRepository
import com.heyoh.homedata.domain.usecase.GetAuthorsUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    //Domain
    single<AuthorRemoteDataStore> { AuthorRemoteDataStoreImpl() }
    single<AuthorRepository> { AuthorRepositoryImpl(get()) }
    //Data
    factory { GetAuthorsUseCase(get()) }
    //View
    viewModel { HomeViewModel(get()) }
}