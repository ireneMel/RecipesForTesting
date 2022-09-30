package com.miller.recipesfortesting.data.local

import android.content.Context
import android.content.res.AssetManager
import com.miller.recipesfortesting.data.models.Recipe
import java.io.File
import java.io.InputStream

class RecipeStore {

    private val _recipes = mutableListOf<Recipe>()
    val recipes: ArrayList<Recipe>
        get() = _recipes as ArrayList<Recipe>

    private val _lookupTable = HashMap<String, Recipe>()

    fun init(context: Context, directory: String) {
        val streams = getAssetStreams(context.assets, directory)
        _recipes.clear()
        streams.forEach {
            val recipe = Recipe.readFromStream(it)
            _recipes.add(recipe)
            _lookupTable[recipe.id] = recipe
        }
    }

    private fun getAssetStreams(manager: AssetManager, directory: String): List<InputStream> {
        val fileNames = getFileNames(manager, directory)
        val streams = mutableListOf<InputStream>()

        fileNames.forEach {
            val stream = manager.open(File(directory, it).path)
            streams.add(stream)
        }
        return streams.toList()
    }

    fun getRecipe(id: String): Recipe? {
        return _lookupTable[id]
    }

    companion object {
        private fun getFileNames(manager: AssetManager, directory: String?): Array<String> {
            if (directory == null) return emptyArray()
            return manager.list(directory) ?: emptyArray()
        }
    }
}