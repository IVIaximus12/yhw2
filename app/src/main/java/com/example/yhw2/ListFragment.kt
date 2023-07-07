package com.example.yhw2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yhw2.recycler.TodoAdapter
import com.example.yhw2.recycler.TodoOffsetItemDecoration

class ListFragment : Fragment(R.layout.fragment_list) {

    lateinit var todoRecyclerView: RecyclerView
    private val todoItemRepository = TodoItemsRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todoRecyclerView = view.findViewById(R.id.recycler_view)
        val todoAdapter = TodoAdapter(requireContext())
        val layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false)

        todoRecyclerView.adapter = todoAdapter
        todoRecyclerView.layoutManager = layoutManager
        todoRecyclerView.addItemDecoration(DividerItemDecoration(
            requireContext(),
            layoutManager.orientation))
        todoRecyclerView.addItemDecoration(
            TodoOffsetItemDecoration(
                bottomOffset = 16.dp(requireContext()).toInt(),
                topOffset = 16.dp(requireContext()).toInt()))
        todoAdapter.tasks = todoItemRepository.getTasks()

    }
}

fun Int.dp(context: Context) = context.resources.displayMetrics.density * this