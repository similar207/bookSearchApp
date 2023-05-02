package com.example.bookSearchApp.ui

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookSearchApp.domain.model.BookModel

class BookAdapter : ListAdapter<BookModel, RecyclerView.ViewHolder>(BookModelDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val book = getItem(position)
        (holder as BookViewHolder).bind(book)
    }


    }
    class BookViewHolder(
        composeView: ComposeView
    ) : RecyclerView.ViewHolder(composeView) {

        fun bind(bookModel: BookModel) {
            println(bookModel)
            (itemView as ComposeView).setContent {
                BookItemView(bookModel)
            }
            itemView.setOnClickListener(){

            }
        }
    }

private class BookModelDiffCallback : DiffUtil.ItemCallback<BookModel>() {
    override fun areItemsTheSame(oldItem: BookModel, newItem: BookModel): Boolean {
        return oldItem.title == newItem.title

    }

    override fun areContentsTheSame(oldItem: BookModel, newItem: BookModel): Boolean {
        return oldItem == newItem
    }
}

