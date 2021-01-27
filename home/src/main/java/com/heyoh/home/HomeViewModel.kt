package com.heyoh.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heyoh.home.module.HomeModel
import com.heyoh.homedata.domain.usecase.GetAuthorsUseCase
import com.heyoh.model.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getAuthorsUseCase: GetAuthorsUseCase
) : ViewModel() {

    private val _model = MutableLiveData<HomeModel>()
    val model: LiveData<HomeModel> get() = _model

    fun getAuthors() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getAuthorsUseCase.invoke()
            }
            when (result) {
                is Result.Success -> _model.value = HomeModel.Success(result.value)
                is Result.Error -> _model.value = HomeModel.Error
            }
        }
    }
}