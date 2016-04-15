package com.shiva0705.sample.musicfy.data.preferences

import com.shiva0705.sample.musicfy.core.dagger.componentProvider.AppComponentProvider
import com.shiva0705.sample.musicfy.data.preferences.core.BasePreference
import com.shiva0705.sample.musicfy.data.preferences.core.Prefereneces
import com.shiva0705.sample.musicfy.models.Tracks

class SelectionPreference : BasePreference(){

    init{
        AppComponentProvider.appComponent.inject(this)
    }

    fun saveSelectionOrder(genre : String, tracks: Tracks) = commit(getGenrePrefName(genre), tracks)

    fun getSelection(genre : String) : Tracks? = read(getGenrePrefName(genre), Tracks::class.java)

    private fun getGenrePrefName(genre : String): String{
        var builder = StringBuilder(Prefereneces.song_selection_by_genre)
        builder.append("_")
        builder.append(genre)
        return builder.toString()
    }
}