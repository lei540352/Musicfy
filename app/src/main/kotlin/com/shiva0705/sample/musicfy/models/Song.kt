package com.shiva0705.sample.musicfy.models

class Song(
        val name: String,
        val popularity: Double,
        val type: String,
        val uri: String,
        val artists : List<Artist>,
        val album : Album
) {}
