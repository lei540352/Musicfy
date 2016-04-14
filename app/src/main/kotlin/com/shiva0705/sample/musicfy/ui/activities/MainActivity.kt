package com.shiva0705.sample.musicfy.ui.activities

import android.os.Bundle
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.musicfy.ui.activities.core.BaseActivity
import com.shiva0705.sample.musicfy.ui.fragments.SelectSongFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(SelectSongFragment.newInstance("rock"))
    }

}
