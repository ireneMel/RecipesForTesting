package com.miller.recipesfortesting.data.local

interface Favourites {
    fun get(id: String): Boolean
    fun toggle(id: String): Boolean
}