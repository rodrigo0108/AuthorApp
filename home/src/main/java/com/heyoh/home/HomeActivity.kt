package com.heyoh.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.heyoh.home.module.HomeModel
import com.heyoh.home.module.homeModule
import com.heyoh.model.home.Author
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadKoinModules(homeModule)

        viewModel.model.observe(this, Observer(::homeModelResult))
        viewModel.getAuthors()
    }

    private fun homeModelResult(homeModel: HomeModel) {
        when (homeModel) {
            is HomeModel.Success -> {
                val result = homeModel.value
                showToast(result[1].firstName)
            }
            is HomeModel.Error -> {
                showToast("Error")
            }
        }
    }

    private fun showToast(content: String){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }
}