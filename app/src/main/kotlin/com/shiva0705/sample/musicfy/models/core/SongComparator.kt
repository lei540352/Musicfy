package com.shiva0705.sample.musicfy.models.core

import com.shiva0705.sample.musicfy.models.Song
import java.util.*

class SongComparator : Comparator<Song>{

    override fun compare(p0: Song, p1: Song): Int {
        return p1.popularity.compareTo(p0.popularity)
    }
}
