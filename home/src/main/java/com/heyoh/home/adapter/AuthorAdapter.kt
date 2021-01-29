package com.heyoh.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heyoh.home.databinding.ItemAuthorBinding
import com.heyoh.model.home.Author
import com.squareup.picasso.Picasso

class AuthorAdapter : RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>() {

    private var list = listOf<Author>()

    fun fillList(newList: List<Author>) {
        this.list = newList
        notifyDataSetChanged()
    }

    inner class AuthorViewHolder(private val binding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(author: Author) {
            with(author) {
                val fullName = "$firstName $lastName"
                binding.titleTextView.text = fullName
                Picasso.get()
                    .load(imgUrl)
                    .into(binding.authorImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val binding = ItemAuthorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AuthorViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        holder.bind(list[position])
    }
}