package com.shiva0705.sample.musicfy.domain

import android.app.Activity
import com.shiva0705.sample.musicfy.core.dagger.componentProvider.AppComponentProvider
import com.shiva0705.sample.musicfy.ui.activities.core.ActivityStartupHelper
import com.shiva0705.sample.musicfy.ui.fragments.GameResultFragment
import com.shiva0705.sample.musicfy.ui.fragments.SelectSongFragment
import com.shiva0705.sample.musicfy.ui.fragments.core.BaseFragment
import javax.inject.Inject

class GameEngine {

    @Inject lateinit var scorer: Scorer

    init {
        AppComponentProvider.appComponent.inject(this)
    }

    var currentGenreIndex: Int = 0

    fun nextStep(): BaseFragment {
        if (currentGenreIndex < GameConfig.game_genres.size) {
            var fragment = SelectSongFragment.newInstance(GameConfig.game_genres[currentGenreIndex])
            currentGenreIndex += 1
            return fragment

        } else {

            var score = scorer.getScore()
            return GameResultFragment.newInstance(score)
        }

    }

    fun reset(activity : Activity){
        currentGenreIndex = 0
        ActivityStartupHelper.startMainActivity(activity)
    }
}