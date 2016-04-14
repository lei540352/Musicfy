package com.shiva0705.sample.musicfy.data.preferences

import com.shiva0705.sample.musicfy.core.app.MusicfyApp
import com.shiva0705.sample.musicfy.data.preferences.core.BasePreference
import com.shiva0705.sample.musicfy.data.preferences.core.Prefereneces
import com.shiva0705.sample.musicfy.models.Song

class SelectionPreference : BasePreference(){

    init{
        MusicfyApp.instance.prefComponent.inject(this)
    }

    fun saveSelectionOrder(genre : String, songs : List<Song>) = commit(Prefereneces.song_selection_by_genre + "_" + genre, songs)

    /*fun get() : DataModel.Location? = read(Prefereneces.selected_location, DataModel.Location::class.java)*/
}