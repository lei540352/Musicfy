package com.shiva0705.sample.musicfy.ui.activities

import android.os.Bundle
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.musicfy.core.app.MusicfyApp
import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import com.shiva0705.sample.musicfy.domain.GameConfig
import com.shiva0705.sample.musicfy.domain.Scorer
import com.shiva0705.sample.musicfy.ui.activities.core.BaseActivity
import com.shiva0705.sample.musicfy.ui.fragments.SelectSongFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {


    var currentGenreIndex: Int = 0

    @Inject lateinit var selectionPref : SelectionPreference
    @Inject lateinit var scorer : Scorer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MusicfyApp).appComponent.inject(this)

        setContentView(R.layout.activity_main)
        startGameEngine()
    }

    fun startGameEngine(){
        nextGenre()
    }

    fun nextGenre(){
        if(currentGenreIndex < GameConfig.game_genres.size) {
            showFragment(SelectSongFragment.newInstance(GameConfig.game_genres[currentGenreIndex]))
            currentGenreIndex += 1
        }else {

            scorer.getScore()
        }
    }


}
