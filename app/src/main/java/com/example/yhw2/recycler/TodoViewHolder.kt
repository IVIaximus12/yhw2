package com.example.yhw2.recycler

import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yhw2.R
import com.example.yhw2.TodoItem

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val todoText: TextView = itemView.findViewById(R.id.task_text)
    private val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)

    fun onBind(todoItem: TodoItem) {
        todoText.text = todoItem.text
        checkBox.isChecked = todoItem.isDone

    }
}