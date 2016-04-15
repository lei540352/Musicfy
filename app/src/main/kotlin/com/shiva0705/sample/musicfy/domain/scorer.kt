package com.shiva0705.sample.musicfy.domain

import com.shiva0705.sample.musicfy.core.app.MusicfyApp
import com.shiva0705.sample.musicfy.data.preferences.SelectionPreference
import com.shiva0705.sample.musicfy.models.Tracks
import javax.inject.Inject

class Scorer {

    @Inject lateinit var scoreGatherer : ScoreCompiler
    @Inject lateinit var selectionPref : SelectionPreference

    init{
        MusicfyApp.instance.appComponent.inject(this)
    }

    fun getScore() : Int{
        var nodePos = findStartNode()
        var score = 0

        for(column in 1 .. GameConfig.game_genres.size - 1){
            var tracks = readSelection(GameConfig.game_genres[column])

            nodePos =  scoreGatherer.getNextNode(nodePos, tracks!!)
            score += tracks.tracks[nodePos].popularity

        }
        return score
    }

    fun findStartNode() : Int{
        var tracks = readSelection(GameConfig.game_genres[0])
        var pos = tracks?.mostPopularSongPos() ?: 0
        return pos
    }

    fun readSelection(genre : String) : Tracks? = selectionPref.getSelection(genre)
}