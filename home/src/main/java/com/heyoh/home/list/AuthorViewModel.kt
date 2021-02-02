package com.heyoh.home.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heyoh.homedata.domain.usecase.GetAuthorsUseCase
import com.heyoh.model.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthorViewModel (
    private val getAuthorsUseCase: GetAuthorsUseCase
) : ViewModel() {

    private val _model = MutableLiveData<AuthorListModel>()
    val model: LiveData<AuthorListModel> get() = _model

    fun getAuthors() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getAuthorsUseCase.invoke()
            }
            when (result) {
                is Result.Success -> _model.value = AuthorListModel.Success(result.value)
                is Result.Error -> _model.value = AuthorListModel.Error
            }
        }
    }
}