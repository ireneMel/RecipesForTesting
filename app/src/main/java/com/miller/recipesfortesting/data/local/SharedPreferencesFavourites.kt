package com.miller.recipesfortesting.data.local

import android.content.Context

class SharedPreferencesFavourites(
    context: Context
) {
    private val sharedPreferences = context.getSharedPreferences("favourites", Context.MODE_PRIVATE)

    fun get(id: String): Boolean {
        return sharedPreferences.getBoolean(id, false)
    }

    fun put(id: String, isSelected: Boolean) {
        val editor = sharedPreferences.edit()
        if (isSelected) editor.putBoolean(id, true)
        else editor.remove(id)
        editor.apply()
    }

    fun toggle(id: String): Boolean {
        val isSelected = get(id)
        put(id, !isSelected)
        return !isSelected
    }
}