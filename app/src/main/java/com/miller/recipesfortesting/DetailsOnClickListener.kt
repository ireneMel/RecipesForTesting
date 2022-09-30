package com.miller.recipesfortesting

import android.view.View
import com.miller.recipesfortesting.data.models.Recipe

interface DetailsOnClickListener {
    fun onDetailsClickListener(view: View, recipe: Recipe)
}