package com.shiva0705.sample.musicfy.domain

import com.shiva0705.sample.musicfy.core.dagger.componentProvider.AppComponentProvider
import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import com.shiva0705.sample.musicfy.models.Tracks
import javax.inject.Inject

class Scorer {

    @Inject lateinit var scoreGatherer : ScoreCompiler
    @Inject lateinit var selectionPref : SelectionPreference

    init{
        AppComponentProvider.appComponent.inject(this)
    }

    fun getScore() : Int{

        var tracks = readSelection(GameConfig.game_genres[0])
        var nodePos = tracks!!.mostPopularSongPos()

        var score = tracks.tracks[nodePos].popularity

        for(column in 1 .. GameConfig.game_genres.size - 1){
            var tracks = readSelection(GameConfig.game_genres[column])

            nodePos =  scoreGatherer.getNextNode(nodePos, tracks!!)
            score += tracks.tracks[nodePos].popularity

        }
        return score
    }

    fun readSelection(genre : String) : Tracks? = selectionPref.getSelection(genre)
}