package com.shiva0705.sample.musicfy.ui.activities

import android.os.Bundle
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.musicfy.ui.activities.core.BaseActivity
import com.shiva0705.sample.musicfy.ui.fragments.SelectSongFragment

class MainActivity : BaseActivity() {

    val game_genres : Array<String> = arrayOf("rock", "edm", "metal", "garage")
    var currentGenreIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startGame()
    }

    fun startGame(){
        nextGenre()
    }

    fun nextGenre(){
        if(currentGenreIndex < game_genres.size) {
            showFragment(SelectSongFragment.newInstance(game_genres[currentGenreIndex]))
            currentGenreIndex += 1
        }else {

        }

    }
}
