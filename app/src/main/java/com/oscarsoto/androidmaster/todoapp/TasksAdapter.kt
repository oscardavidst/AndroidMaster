package com.oscarsoto.androidmaster.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscarsoto.androidmaster.R

class TasksAdapter(var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener { onTaskSelected(position) }

    }

    override fun getItemCount(): Int = tasks.size
}