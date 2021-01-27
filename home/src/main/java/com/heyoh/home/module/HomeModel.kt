package com.heyoh.home.module

sealed class HomeModel {
    data class Success(val value: Any): HomeModel()
    object Error: HomeModel()
    object Loading: HomeModel()
}