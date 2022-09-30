package com.miller.recipesfortesting.injection

import android.app.Application
import com.miller.recipesfortesting.data.local.Favourites
import com.miller.recipesfortesting.data.local.SharedPreferencesFavourites

open class RecipeApplication : Application() {
    private var favourites: SharedPreferencesFavourites? = null

    open fun getFavourites(): Favourites {
        if (favourites == null) {
            favourites = SharedPreferencesFavourites(this)
        }
        return favourites as SharedPreferencesFavourites
    }
}