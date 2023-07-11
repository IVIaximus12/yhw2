package com.example.yhw2

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.Calendar

class AddItemFragment  : Fragment(R.layout.fragment_add_item) {
    
    private lateinit var datePickerDialog: DatePickerDialog
    
    private lateinit var cancelButton: ImageView
    private lateinit var saveButton: TextView
    private lateinit var dateLayout: View
    private lateinit var importanceLayout: View
    private lateinit var importanceValue: TextView
    private lateinit var importance: TextView
    private lateinit var dateText: TextView
    private lateinit var switch: SwitchCompat

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initDatePicker()
        setListeners()
    }

    private fun initViews(view: View) {
        cancelButton = view.findViewById(R.id.cancel_button)
        saveButton = view.findViewById(R.id.save_button)
        dateLayout = view.findViewById(R.id.date_layout)
        dateText = view.findViewById(R.id.date_text)
        switch = view.findViewById(R.id.date_switch)
        importanceLayout = view.findViewById(R.id.importance_layout)
        importanceValue = view.findViewById(R.id.importance_value)
        importance = view.findViewById(R.id.importance)
    }

    private fun initDatePicker() {
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            val realMonth = month + 1
            val date = "$dayOfMonth/$realMonth/$year"
            dateText.text = date
        }

        val calendar = Calendar.getInstance()

        datePickerDialog = DatePickerDialog(
            requireContext(),
            dateListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    private fun setListeners() {
        val clickListener = OnClickListener {
            findNavController().popBackStack()
        }
        cancelButton.setOnClickListener(clickListener)
        saveButton.setOnClickListener(clickListener)
        
        dateLayout.setOnClickListener {
            datePickerDialog.show()
        }
        
        switch.setOnCheckedChangeListener { _, isChecked ->
            dateLayout.isClickable = isChecked
            if (isChecked) {
                dateText.visibility = View.VISIBLE
            } else {
                dateText.visibility = View.INVISIBLE
            }
        }

        importanceLayout.setOnClickListener {
            showPopupMenu()
        }
    }

    private fun showPopupMenu() {
        val popupMenu = PopupMenu(requireContext(), importance)

        popupMenu.menu.add(0, ID_POPUP_NORMAL, Menu.NONE, Importance.Normal.text)
        popupMenu.menu.add(0, ID_POPUP_LOW, Menu.NONE, Importance.Low.text)
        popupMenu.menu.add(0, ID_POPUP_HIGH, Menu.NONE, Importance.High.text)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                ID_POPUP_NORMAL -> {
                    setImportanceColor(true)
                    importanceValue.text = requireContext().getString(R.string.importance_normal)
                }
                ID_POPUP_LOW -> {
                    setImportanceColor(true)
                    importanceValue.text = requireContext().getString(R.string.importance_low)
                }
                ID_POPUP_HIGH -> {
                    setImportanceColor(false)
                    importanceValue.text = requireContext().getString(R.string.importance_high)
                }
            }
            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }

    private fun setImportanceColor(isNormalImportance: Boolean) {
        if (isNormalImportance) {
            if (false) {
                TODO("Not yet implemented. Проверка на то какой параметр стоял уже, чтобы цвет зря не менять")
            }
            importanceValue.setTextColor(requireContext().getColor(R.color.label_primary))
        } else {
            importanceValue.setTextColor(requireContext().getColor(R.color.red))
        }
    }


    companion object {
        const val ID_POPUP_NORMAL = 1
        const val ID_POPUP_LOW = 2
        const val ID_POPUP_HIGH = 3
    }
}