package com.heyoh.home.module

import com.heyoh.model.home.Author

sealed class HomeModel {
    data class Success(val value: List<Author>): HomeModel()
    object Error: HomeModel()
    object Loading: HomeModel()
}