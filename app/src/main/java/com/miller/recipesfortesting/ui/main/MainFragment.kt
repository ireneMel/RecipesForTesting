package com.miller.recipesfortesting.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.miller.recipesfortesting.DetailsOnClickListener
import com.miller.recipesfortesting.R
import com.miller.recipesfortesting.data.local.RecipeStore
import com.miller.recipesfortesting.data.models.Recipe
import com.miller.recipesfortesting.databinding.FragmentMainBinding

class MainFragment : Fragment(), DetailsOnClickListener {
    private lateinit var binding: FragmentMainBinding
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var listener: DetailsOnClickListener
    private val store = RecipeStore()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        store.init(requireContext(), "recipes")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        listener = this
        recipeAdapter = RecipeAdapter(store.recipes, listener)

        binding.recipes.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = recipeAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDetailsClickListener(view: View, recipe: Recipe) {
        val fragment = DescriptionFragment.newInstance(recipe.id)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}