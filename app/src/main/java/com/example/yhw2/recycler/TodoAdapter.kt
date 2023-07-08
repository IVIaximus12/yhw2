package com.example.yhw2.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yhw2.R
import com.example.yhw2.TodoItem

class TodoAdapter (
    private val context: Context,
    private val clickCallback: () -> Unit
) : RecyclerView.Adapter<TodoViewHolder>() {

    var tasks: List<TodoItem> = emptyList()
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            layoutInflater.inflate(
                R.layout.todo_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBind(tasks[position])
        holder.itemView.setOnClickListener {
            clickCallback()
        }
    }
}