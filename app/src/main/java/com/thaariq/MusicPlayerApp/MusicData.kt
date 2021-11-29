package com.thaariq.MusicPlayerApp

import com.thaariq.musicplayerapp.R

object MusicData {
    private val musicnames = arrayOf("dontmakemefallinlove",
    "Bossa no Se",
    "Random Access Memories",
    "Best Part",
    "Location Unknown",
    "Take Me to Church",
    "Sanctuary",
    "Gimme Love")

    private val musicalbums = arrayOf("Chiquito",
    "para mi",
    "Random Access Memories",
    "Best Part",
    "Get Back",
    "There's Something under My Bed",
    "Sanctuary",
    "Nectar")

    private val musiccover = intArrayOf(
        R.drawable.cuco1,
        R.drawable.cuco2,
        R.drawable.daftpunk,
        R.drawable.her,
        R.drawable.honne,
        R.drawable.hozier,
        R.drawable.joji1,
        R.drawable.joji2
    )

    val listdata: ArrayList<Music>
        get() {
            val list = arrayListOf<Music>()
            for (position in musicnames.indices){
                val music = Music()
                music.name = musicnames[position]
                music.album = musicalbums[position]
                music.cover = musiccover[position]
                list.add(music)
            }
            return list
        }
}