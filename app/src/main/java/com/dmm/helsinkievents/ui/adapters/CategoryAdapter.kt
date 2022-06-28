package com.dmm.helsinkievents.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmm.helsinkievents.databinding.ItemCategoriesBinding
import com.dmm.helsinkievents.model.Category

class CategoryAdapter ( private val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder>() {

    inner class CategoryAdapterViewHolder(private val binding: ItemCategoriesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
           binding.category = category
            //Changue
           binding.layoutCategory.setOnClickListener {
               binding.layoutCategory.isSelected = !binding.layoutCategory.isSelected
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterViewHolder {
        val binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context))
        return CategoryAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapterViewHolder, position: Int) {
        val item = categories[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = categories.size
}