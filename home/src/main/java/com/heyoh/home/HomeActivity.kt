package com.heyoh.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import com.heyoh.home.adapter.AuthorAdapter
import com.heyoh.home.databinding.ActivityHomeBinding
import com.heyoh.home.module.HomeModel
import com.heyoh.home.module.homeModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: AuthorAdapter
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(homeModule)
        viewModel.model.observe(this, Observer(::homeModelResult))
        viewModel.getAuthors()
        adapter = AuthorAdapter()
        binding.authorRecyclerView.adapter = adapter
    }

    private fun homeModelResult(homeModel: HomeModel) {
        when (homeModel) {
            is HomeModel.Success -> {
                adapter.fillList(homeModel.value)
            }
            is HomeModel.Error -> {
                showToast("Error")
            }
        }
    }

    private fun showToast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }
}