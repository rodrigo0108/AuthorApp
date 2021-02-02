package com.heyoh.home.list

import com.heyoh.model.home.Author

sealed class AuthorListModel {
    data class Success(val value: List<Author>) : AuthorListModel()
    object Error : AuthorListModel()
    object Loading : AuthorListModel()
}