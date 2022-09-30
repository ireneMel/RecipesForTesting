package com.miller.recipesfortesting.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.miller.recipesfortesting.R
import com.miller.recipesfortesting.data.local.RecipeStore
import com.miller.recipesfortesting.data.local.SharedPreferencesFavourites
import com.miller.recipesfortesting.databinding.FragmentDescriptionBinding

private const val ID = "id"

class DescriptionFragment : Fragment() {
    private lateinit var binding: FragmentDescriptionBinding

    private val store = RecipeStore()
    private lateinit var sharedPreferences: SharedPreferencesFavourites

    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDescriptionBinding.bind(view)
        store.init(requireContext(), "recipes")
        sharedPreferences = SharedPreferencesFavourites(requireContext())
        val recipe = store.getRecipe(id ?: "-1") ?: return
        val isFavSelected = sharedPreferences.get(recipe.id)

        binding.description.text = recipe.description

        binding.title.apply {
            text = recipe.title
            isSelected = isFavSelected
            setOnClickListener {
                val fav = sharedPreferences.toggle(recipe.id)
                isSelected = fav
                invalidate()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            DescriptionFragment().apply {
                arguments = Bundle().apply {
                    putString(ID, param1)
                }
            }
    }

}