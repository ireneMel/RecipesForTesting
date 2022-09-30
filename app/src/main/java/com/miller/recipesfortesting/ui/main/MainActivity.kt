package com.miller.recipesfortesting.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.miller.recipesfortesting.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //navigate to main fragment
        supportFragmentManager.commit {
            replace(R.id.container, MainFragment())
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount != 0) supportFragmentManager.popBackStack()
        else super.onBackPressed()
    }
}