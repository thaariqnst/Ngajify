package com.thaariq.MusicPlayerApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thaariq.MusicPlayerApp.data.Music
import com.thaariq.MusicPlayerApp.data.MusicData
import com.thaariq.musicplayerapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var rvMusic: RecyclerView
    private var list:ArrayList<Music> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMusic= findViewById(R.id.rv_music_list)
        rvMusic.setHasFixedSize(true)

        list.addAll(MusicData.listdata)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMusic.layoutManager= LinearLayoutManager(this)
        val listMusicAdapter= ListMusicAdapter(list)
        rvMusic.adapter = listMusicAdapter
    }
}