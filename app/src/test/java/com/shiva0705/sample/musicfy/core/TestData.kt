package com.shiva0705.sample.musicfy.core

import com.shiva0705.sample.musicfy.models.*
import java.util.*

object TestData {

    val testTracks: Tracks
        get() {
            val artists = ArrayList<Artist>()
            val images = ArrayList<Images>()
            val album = Album("12", images)

            val lst = ArrayList<Song>()
            lst.add(Song("Song 1", 10, "", "", artists, album))
            lst.add(Song("Song 2", 20, "", "", artists, album))
            lst.add(Song("Song 3", 30, "", "", artists, album))
            lst.add(Song("Song 4", 70, "", "", artists, album))
            lst.add(Song("Song 5", 34, "", "", artists, album))

            val tracks = Tracks(lst)
            return tracks
        }
}
