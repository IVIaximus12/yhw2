package com.example.yhw2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yhw2.recycler.TodoAdapter
import com.example.yhw2.recycler.TodoOffsetItemDecoration

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var todoRecyclerView: RecyclerView
    private lateinit var addNewButton: ImageButton
    private val todoItemRepository = TodoItemsRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setRecyclerView()
        setListeners()
    }

    private fun initViews(view: View) {
        todoRecyclerView = view.findViewById(R.id.recycler_view)
        addNewButton = view.findViewById(R.id.add_new_button)
    }

    private fun setListeners() {
        addNewButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addItemFragment)
        }
    }
    private fun setRecyclerView() {
        val todoAdapter = TodoAdapter(requireContext()
        ) { findNavController().navigate(R.id.action_listFragment_to_addItemFragment) }
        todoAdapter.tasks = todoItemRepository.getTasks()

        val layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false)

        todoRecyclerView.adapter = todoAdapter
        todoRecyclerView.layoutManager = layoutManager
        todoRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                layoutManager.orientation))
        todoRecyclerView.addItemDecoration(
            TodoOffsetItemDecoration(
                bottomOffset = 16.dp(requireContext()).toInt(),
                topOffset = 16.dp(requireContext()).toInt()))
    }
}

fun Int.dp(context: Context) = context.resources.displayMetrics.density * this