package com.shiva0705.sample.musicfy.data.api

import com.shiva0705.sample.musicfy.models.Tracks
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface SpotifyApi {

    @GET("recommendations")
    fun search(@Query("seed_genres") query : String, @Query("limit") limit : Int): Observable<Tracks>

}