package com.decadev.a2ndandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter : RecyclerView.Adapter<TodoListViewHolder>() {
    var todoList = arrayListOf("Android Development", "House work", "Errands")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.to_do_list_layout, parent, false)

        return TodoListViewHolder(view)
    }

    override fun getItemCount() = todoList.size

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = todoList[position]
    }
}