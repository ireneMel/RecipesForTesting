package com.miller.recipesfortesting.data.models

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


data class Recipe(
    val id: String,
    val title: String,
    val description: String
) {
    companion object {
        private const val ID_PREFIX = "id="
        private const val TITLE_PREFIX = "title="

        fun readFromStream(stream: InputStream): Recipe {
            var id = "null"
            var title = "null"
            val description = StringBuilder()
            val reader = BufferedReader(InputStreamReader(stream))

            reader.forEachLine {
                if (it.startsWith("id")) {
                    id = it.substring(ID_PREFIX.length)
                    return@forEachLine
                }
                if (it.startsWith("title")) {
                    title = it.substring(TITLE_PREFIX.length)
                    return@forEachLine
                }
                if (description.isNotEmpty())
                    description.append("\n")
                description.append(it)
            }
            return Recipe(id, title, description.toString())
        }
    }
}

