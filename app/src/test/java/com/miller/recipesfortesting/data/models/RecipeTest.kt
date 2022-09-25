package com.miller.recipesfortesting.data.models

import junit.framework.TestCase
import org.junit.Test

/**
 * Class was written according to TDD technique
 */
internal class RecipeTest {
    @Test
    fun water() {
        val stream = this::class.java
            .getResourceAsStream("/recipes/water.txt")
            ?: throw IllegalArgumentException("Could not find file.")
        val recipe = Recipe.readFromStream(stream)
        TestCase.assertNotNull(recipe)
        TestCase.assertEquals("water", recipe.id)
        TestCase.assertEquals("Water", recipe.title)
        TestCase.assertEquals(
            "Put glass under tap. Open tap. Close tap. Drink.",
            recipe.description
        )
    }

    @Test
    fun mixed() {
        val stream = this::class.java
            .getResourceAsStream("/recipes/mixed.txt")
            ?: throw IllegalArgumentException("Could not find file.")
        val recipe = Recipe.readFromStream(stream)
        TestCase.assertNotNull(recipe)
        TestCase.assertEquals("punch", recipe.id)
        TestCase.assertEquals("Punch", recipe.title)
        TestCase.assertEquals(
            "Juice of 3 lemons\n" +
                    "1 orange\n" +
                    "1 pint grape juice\n" +
                    "1 cup sugar\n" +
                    "1 cup water\n" +
                    "1 pine apple juice\n" +
                    "Mix all together and strain. Add large piece of ice.", recipe.description
        )
    }
}