package com.dmm.helsinkievents.ui.fragments

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmm.helsinkievents.R
import com.dmm.helsinkievents.databinding.HomeFragmentBinding
import com.dmm.helsinkievents.model.Category
import com.dmm.helsinkievents.ui.adapters.CategoryAdapter

class HomeFragment : BaseFragment<HomeFragmentBinding>(
    HomeFragmentBinding::inflate
) {

    override fun setupUI() {
        super.setupUI()

        binding.rvCategories.apply {
            adapter = CategoryAdapter(getCategoryList())
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun getCategoryList(): List<Category> {
        val categoryName = resources.getStringArray(R.array.categories_name)
        val categoryIcons = resources.obtainTypedArray(R.array.categories_image)

        return categoryName.mapIndexed { i, categoryName ->
            val drawable : Drawable? = categoryIcons.getDrawable(i)
            drawable.let {
                Category(categoryName, it!!)
            }
        }
    }
}