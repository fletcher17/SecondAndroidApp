package com.decadev.a2ndandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(val lists: ArrayList<TaskList>) : RecyclerView.Adapter<TodoListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.to_do_list_layout, parent, false)

        return TodoListViewHolder(view)
    }

    override fun getItemCount() = lists.size

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = lists[position].name
    }

    //we update the list
    fun addList(list: TaskList) {
        lists.add(list)
        //The recyclerview needs to know that an item has been inserted
        notifyItemInserted(lists.size-1)
    }
}