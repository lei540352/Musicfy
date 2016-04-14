package com.shiva0705.sample.musicfy.ui.activities.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.musicfy.ui.fragments.core.BaseFragment


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun showFragment(fragment: BaseFragment) = fragmentManager
            .beginTransaction()
            .setCustomAnimations(R.animator.slide_in, R.animator.slide_out)
            .replace(R.id.view_container, fragment)
            .addToBackStack(fragment.tag)
            .commit()
}