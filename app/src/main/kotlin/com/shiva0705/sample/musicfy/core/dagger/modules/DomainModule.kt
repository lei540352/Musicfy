package com.shiva0705.sample.musicfy.core.dagger.modules

import com.shiva0705.sample.musicfy.domain.ScoreGatherer
import com.shiva0705.sample.musicfy.domain.Scorer
import dagger.Module
import dagger.Provides

@Module
class DomainModule(){

    @Provides
    fun provideScoreGatherer() : ScoreGatherer = ScoreGatherer()

    @Provides
    fun provideScorer() : Scorer = Scorer()
}