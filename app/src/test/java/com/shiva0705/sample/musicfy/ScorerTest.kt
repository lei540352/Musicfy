package com.shiva0705.sample.musicfy

import com.shiva0705.sample.musicfy.core.TestData
import com.shiva0705.sample.musicfy.domain.Scorer
import org.junit.Test

class ScorerTest {

    @Test
    fun testFindFirstNode() {
        val tracks = TestData.testTracks

        val scorer = Scorer()

        var startNode = scorer.findStartNode()
        if (startNode !== 3) throw AssertionError()

    }
}
