package com.shiva0705.sample.musicfy

import com.shiva0705.sample.musicfy.core.TestData
import org.junit.Test

class TracksTest {

    @Test
    fun testMostPopularSong() {

        val tracks = TestData.testTracks
        val pos = tracks.mostPopularSongPos()

        if (pos !== 3) throw AssertionError()

    }
}
