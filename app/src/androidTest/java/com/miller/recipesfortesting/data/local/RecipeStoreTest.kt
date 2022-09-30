package com.miller.recipesfortesting.data.local

import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

internal class RecipeStoreTest {
    @Test
    fun count() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val store = RecipeStore()
        store.init(context, "recipes")
        assertEquals(4, store.recipes.size)
    }

    @Test
    fun getChocolatePudding() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val store = RecipeStore()
        store.init(context, "recipes")
        val recipe = store.getRecipe("chocolate_pudding")
        assertNotNull(recipe)
        assertEquals("chocolate_pudding", recipe?.id)
        assertEquals("Chocolate Pudding", recipe?.title)
    }
}