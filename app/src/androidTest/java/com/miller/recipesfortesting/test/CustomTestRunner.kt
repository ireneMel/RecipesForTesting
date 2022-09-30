package com.miller.recipesfortesting.test

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.miller.recipesfortesting.injection.TestRecipeApplication

class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, TestRecipeApplication::class.qualifiedName, context)
    }
}