package com.miller.recipesfortesting.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.miller.recipesfortesting.DetailsOnClickListener
import com.miller.recipesfortesting.data.models.Recipe
import com.miller.recipesfortesting.databinding.ItemRecipeBinding

//recycler view adapter best if the list is STATIC
//list adapter best if the list is DYNAMIC
class RecipeAdapter(
    private val recipes: ArrayList<Recipe>,
    private val listener: DetailsOnClickListener
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(val binding: ItemRecipeBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            ItemRecipeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.binding.apply {
            textView.text = recipe.title
            textView.setOnClickListener {
                listener.onDetailsClickListener(it, recipe)
            }
        }
    }

    fun clear() {
        recipes.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = recipes.size
}