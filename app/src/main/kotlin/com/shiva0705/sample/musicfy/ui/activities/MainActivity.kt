package com.shiva0705.sample.musicfy.ui.activities

import android.os.Bundle
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.musicfy.core.dagger.componentProvider.AppComponentProvider
import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import com.shiva0705.sample.musicfy.domain.GameEngine
import com.shiva0705.sample.musicfy.ui.activities.core.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var selectionPref : SelectionPreference
    @Inject lateinit var gameEngine: GameEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponentProvider.appComponent.inject(this)

        setContentView(R.layout.activity_main)
        nextStep()
    }

    fun nextStep(){
        showFragment(gameEngine.nextStep())
    }

}
