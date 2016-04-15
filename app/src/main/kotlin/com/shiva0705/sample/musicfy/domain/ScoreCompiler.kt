package com.shiva0705.sample.musicfy.domain

import com.shiva0705.sample.musicfy.models.Song
import com.shiva0705.sample.musicfy.models.Tracks
import com.shiva0705.sample.musicfy.models.core.SongComparator
import java.util.*

class ScoreCompiler {


    fun getNextNode(nodePos : Int, tracks : Tracks) : Int{
        var pq = gatherNodes(nodePos, tracks)
        Collections.sort(pq, SongComparator())
        return tracks.tracks.indexOf(pq[0])
    }

    private fun gatherNodes(nodePos : Int, tracks: Tracks) : ArrayList<Song>{

        var queue = arrayListOf<Song>()

        if(nodePos -1 > 0) queue.add(tracks.tracks[nodePos-1])
        queue.add(tracks.tracks[nodePos])
        if(nodePos + 1 < GameConfig.game_genres.size) queue.add(tracks.tracks[nodePos+1])

        return queue
    }
}
