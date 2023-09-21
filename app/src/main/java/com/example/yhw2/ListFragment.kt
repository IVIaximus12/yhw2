package com.example.yhw2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
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
    private lateinit var touchLayout: View
    private lateinit var visibleButton: ImageView
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var numberOfCompletedText: TextView
    private val todoItemRepository = TodoItemsRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setRecyclerView()
        setListeners()
        getData()
    }

    private fun initViews(view: View) {
        todoRecyclerView = view.findViewById(R.id.recycler_view)
        addNewButton = view.findViewById(R.id.add_new_button)
        touchLayout = view.findViewById(R.id.list_status_bar)
        visibleButton = view.findViewById(R.id.visible_button)
        numberOfCompletedText = view.findViewById(R.id.number_of_completed_text)
    }

    private fun setListeners() {
        addNewButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addItemFragment)
        }
        touchLayout.setOnClickListener {
            visibleButton.isSelected = !visibleButton.isSelected
            val taskList = todoItemRepository.getTasks()
            if (visibleButton.isSelected) {
                val filteredTaskList = todoItemRepository.getTasks().filter {
                    !it.isDone
                }
                todoAdapter.tasks = filteredTaskList
            } else todoAdapter.tasks = taskList
        }
    }

    private fun setRecyclerView() {
        todoAdapter = TodoAdapter(
            requireContext()
        ) { findNavController().navigate(R.id.action_listFragment_to_addItemFragment) }

        val layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false
        )

        todoRecyclerView.adapter = todoAdapter
        todoRecyclerView.layoutManager = layoutManager
    }

    private fun getData() {
        val taskList = todoItemRepository.getTasks()
        todoAdapter.tasks = taskList
        val count = taskList.count { it.isDone }
        val text = "${numberOfCompletedText.text} $count"
        numberOfCompletedText.text = text
    }
}

fun Int.dp(context: Context) = context.resources.displayMetrics.density * this