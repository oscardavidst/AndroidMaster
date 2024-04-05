package com.oscarsoto.androidmaster.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oscarsoto.androidmaster.R
import com.oscarsoto.androidmaster.todoapp.Category.*

class ToDoActivity : AppCompatActivity() {

    private val categories = listOf(Personal, Business, Other)

    private val tasks = mutableListOf(
        Task("Prueba negocio", Business),
        Task("Prueba personal", Personal),
        Task("Prueba otro", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TasksAdapter

    private lateinit var fabAddTast: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_to_do)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTast = findViewById(R.id.fabAddTask)
    }

    private fun initListeners() {
        fabAddTast.setOnClickListener { showDialogNewTask() }
    }

    private fun initUI() {
        categoriesAdapter =
            CategoriesAdapter(categories) { position -> onCategoryItemSelected(position) }
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TasksAdapter(tasks) { position -> onTaskItemSelected(position) }
        rvTasks.layoutManager =
            LinearLayoutManager(this) // Se deja sin el resto de parámetros porque por defecto es vertical
        rvTasks.adapter = taskAdapter
    }

    private fun showDialogNewTask() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_new_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etNewTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener() {
            if (etTask.text.toString().isNotEmpty()) {
                val selectedCategorieId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton =
                    rgCategories.findViewById(selectedCategorieId)
                val currentCategory: Category = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Business
                    else -> Other
                }
                tasks.add(Task(etTask.text.toString(), currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun onTaskItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun onCategoryItemSelected(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        updateCategories(position)
    }

    private fun updateTasks() {
        val selectedCategories: List<Category> = categories.filter { it.isSelected }
        val newTasks: List<Task> = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }

    private fun updateCategories(position: Int) {
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }
}