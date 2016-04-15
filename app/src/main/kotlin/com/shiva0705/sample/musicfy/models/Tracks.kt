package com.shiva0705.sample.musicfy.models

import com.shiva0705.sample.musicfy.models.core.SongComparator
import java.util.*

class Tracks(val tracks : List<Song>){

    fun mostPopularSongPos() : Int {
        var newTracks = tracks
         Collections.sort(newTracks, SongComparator())

        return tracks.indexOf(newTracks[0])
    }

}
