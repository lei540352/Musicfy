package com.shiva0705.sample.musicfy

import com.shiva0705.sample.musicfy.core.TestData
import com.shiva0705.sample.musicfy.domain.ScoreCompiler
import org.junit.Test

class ScoreCompilerTest {

    @Test
    fun testGetNextNode() {

        val tracks = TestData.testTracks
        val scoreCompiler = ScoreCompiler()

        var node = scoreCompiler.getNextNode(3, tracks)
        if (node !== 3) throw AssertionError()

        node = scoreCompiler.getNextNode(4, tracks)
        if (node !== 3) throw AssertionError()

        node = scoreCompiler.getNextNode(0, tracks)
        if (node !== 1) throw AssertionError()
    }
}
