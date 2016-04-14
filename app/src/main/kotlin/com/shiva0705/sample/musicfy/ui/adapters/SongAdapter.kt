package com.shiva0705.sample.musicfy.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shiva0705.sample.musicfy.R
import com.shiva0705.sample.musicfy.models.Song
import com.shiva0705.sample.musicfy.ui.adapters.core.ItemTouchHelperAdapter
import java.util.*


class SongAdapter(val songs: List<Song>) : RecyclerView.Adapter<SongAdapter.ViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): SongAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_song, parent, false)
        val vh = ViewHolder(v)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]

        holder.songName.text = song.name + " (" + song.popularity + ")"
        holder.songArtist.text = song.artists[0].name
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onItemMove(from: Int, to: Int) {
        Collections.swap(songs, from, to);
        notifyItemMoved(from, to);
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // each data item is just a string in this case
        lateinit var songName: TextView
        lateinit var songArtist: TextView

        init {
            songName = view.findViewById(R.id.song_name) as TextView
            songArtist = view.findViewById(R.id.song_artist) as TextView
        }

    }

}