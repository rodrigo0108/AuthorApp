package com.heyoh.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.heyoh.home.databinding.ItemAuthorBinding
import com.heyoh.model.home.Author
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates

class AuthorAdapter : RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>() {

    var list: List<Author> by Delegates.observable(emptyList()) { _, old, new ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = old[oldItemPosition]
                val newItem = new[newItemPosition]
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition] == new[newItemPosition]
            }

        }).dispatchUpdatesTo(this)
    }

    inner class AuthorViewHolder(private val binding: ItemAuthorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(author: Author) {
            with(author) {
                val fullName = "$firstName $lastName"
                binding.titleTextView.text = fullName
                binding.descriptionTextView.text = description
                Picasso.get()
                    .load(imgUrl)
                    .into(binding.authorShapeableImageView)
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