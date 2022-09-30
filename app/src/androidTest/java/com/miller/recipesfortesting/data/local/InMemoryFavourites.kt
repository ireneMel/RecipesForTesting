package com.miller.recipesfortesting.data.local

class InMemoryFavourites : Favourites {
    private val map = HashMap<String, Boolean>()

    override fun get(id: String): Boolean {
        return map[id] ?: false
    }

    override fun toggle(id: String): Boolean {
        val value = map[id]
        map[id] = !value!!
        return !value
    }

    fun put(id: String, value: Boolean) {
        map[id] = value
    }
}