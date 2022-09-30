package com.miller.recipesfortesting.injection

import com.miller.recipesfortesting.data.local.Favourites
import com.miller.recipesfortesting.data.local.InMemoryFavourites

class TestRecipeApplication : RecipeApplication() {
    private val favourites = InMemoryFavourites()

    override fun getFavourites(): Favourites {
        return favourites
    }
}