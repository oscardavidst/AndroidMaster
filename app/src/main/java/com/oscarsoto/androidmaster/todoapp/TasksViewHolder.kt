package com.oscarsoto.androidmaster.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.oscarsoto.androidmaster.R
import com.oscarsoto.androidmaster.todoapp.Category.*

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task) {
        if (task.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        cbTask.isChecked = task.isSelected
        tvTask.text = task.name

        val colorCategory: Int = when (task.category) {
            Business -> R.color.todo_business_category
            Other -> R.color.todo_other_category
            Personal -> R.color.todo_personal_category
        }
        cbTask.buttonTintList =
            ColorStateList.valueOf(ContextCompat.getColor(cbTask.context, colorCategory))
    }
}