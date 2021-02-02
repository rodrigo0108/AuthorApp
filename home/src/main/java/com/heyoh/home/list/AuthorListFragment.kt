package com.heyoh.home.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.heyoh.home.HomeViewModel
import com.heyoh.home.adapter.AuthorAdapter
import com.heyoh.home.databinding.FragmentAuthorListBinding
import org.koin.android.viewmodel.ext.android.viewModel

class AuthorListFragment : Fragment() {

    private lateinit var adapter: AuthorAdapter
    private var _binding: FragmentAuthorListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthorViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthorListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservable()
        initAdapter()
        viewModel.getAuthors()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservable() {
        viewModel.model.observe(viewLifecycleOwner, Observer(::authorListResult))
    }

    private fun initAdapter() {
        adapter = AuthorAdapter()
        binding.authorRecyclerView.adapter = adapter
    }

    private fun authorListResult(model: AuthorListModel) {
        when (model) {
            is AuthorListModel.Success -> {
                adapter.list = model.value
            }
            is AuthorListModel.Error -> {
                showToast()
            }
        }
    }

    private fun showToast() {
        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
    }
}