package com.example.yhw2

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddItemFragment  : Fragment(R.layout.fragment_add_item) {

    private lateinit var cancelButton: Button
    private lateinit var saveButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setListeners()
    }

    private fun initViews(view: View) {
        cancelButton = view.findViewById(R.id.cancel_button)
        saveButton = view.findViewById(R.id.save_button)
    }

    private fun setListeners() {
        val clickListener = OnClickListener {
            findNavController().popBackStack()
        }
        cancelButton.setOnClickListener(clickListener)
        saveButton.setOnClickListener(clickListener)
    }
}