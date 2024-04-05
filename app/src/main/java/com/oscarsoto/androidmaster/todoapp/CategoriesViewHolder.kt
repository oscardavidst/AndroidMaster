package com.oscarsoto.androidmaster.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.oscarsoto.androidmaster.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val cvCategory: CardView = view.findViewById(R.id.cvCategory)
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)

    fun render(category: Category, onItemSelected: (Int) -> Unit) {

        val colorCategory = if (category.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }
        cvCategory.setCardBackgroundColor(ContextCompat.getColor(cvCategory.context, colorCategory))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (category) {
            Category.Business -> {
                tvCategoryName.text = "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.todo_business_category
                    )
                )
            }

            Category.Other -> {
                tvCategoryName.text = "Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.todo_other_category
                    )
                )
            }

            Category.Personal -> {
                tvCategoryName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.todo_personal_category
                    )
                )
            }
        }
    }
}