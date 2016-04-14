package com.shiva0705.sample.musicfy.domain

import android.util.Log
import com.shiva0705.sample.musicfy.core.app.MusicfyApp
import javax.inject.Inject

class Scorer {

    @Inject lateinit var scoreGatherer : ScoreGatherer

    init{
        MusicfyApp.instance.appComponent.inject(this)
    }

    fun getScore(){
       var m = scoreGatherer.createPopularityMatrix()
        Log.d("test", "test")
    }
}