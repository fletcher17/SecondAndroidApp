package com.decadev.a2ndandroid

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var listPositionTextView = itemView.findViewById<TextView>(R.id.viewNumber)
    var listTitleTextView = itemView.findViewById<TextView>(R.id.textView1)
}