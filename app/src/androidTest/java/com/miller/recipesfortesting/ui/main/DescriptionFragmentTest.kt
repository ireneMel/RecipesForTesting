package com.miller.recipesfortesting.ui.main

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.miller.recipesfortesting.R
import org.hamcrest.CoreMatchers.not
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DescriptionFragmentTest {
    @Test
    fun recipeNotFound() {
        val scenario = launchFragmentInContainer<DescriptionFragment>(
            initialState = Lifecycle.State.INITIALIZED
        )
        // the fragment has gone through onAttach(), but not onCreate()
        scenario.moveToState(Lifecycle.State.RESUMED)
        // EventFragment moves to CREATED -> STARTED -> RESUMED.

        onView(withId(R.id.description))
            .check(matches(withText("Recipe not found")))
        onView(withId(R.id.title))
            .check(matches(withText("Recipe not found")))
    }

    @Test
    fun clickToFavourite() {
        val scenario = launchFragmentInContainer<DescriptionFragment>(
            fragmentArgs = bundleOf(Pair(DescriptionFragment.ID, "creamed_carrots")),
            initialState = Lifecycle.State.INITIALIZED
        )
        // the fragment has gone through onAttach(), but not onCreate()
        scenario.moveToState(Lifecycle.State.RESUMED)
        // EventFragment moves to CREATED -> STARTED -> RESUMED.

        onView(withId(R.id.title)).check(matches(withText("Creamed Carrots")))
            .check(matches(not(isSelected())))
            .perform(click())
            .check(matches(isSelected()))
    }

}