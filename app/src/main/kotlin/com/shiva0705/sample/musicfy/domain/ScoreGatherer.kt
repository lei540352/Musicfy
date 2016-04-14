package com.shiva0705.sample.musicfy.domain

import com.shiva0705.sample.musicfy.core.app.MusicfyApp
import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import javax.inject.Inject

class ScoreGatherer{
    @Inject lateinit var selectionPref : SelectionPreference

    fun createPopularityMatrix() : List<List<Double>>?{
        var m = arrayListOf(arrayListOf<Double>())

        for(i  in 0 .. GameConfig.game_genres.size -1){

            var genre = GameConfig.game_genres[i]
            var songs = selectionPref.getSelection(genre)
            var size = songs?.size ?: 1

            var popularityList  = arrayListOf<Double>()

            if(songs == null) {
                return null
            }

            for(j in 0 .. size-1){
                popularityList.add(j, songs[j].popularity)
            }

            m.add(i, popularityList)
        }
        return m
    }

    init {
        MusicfyApp.instance.appComponent.inject(this)
    }
}
