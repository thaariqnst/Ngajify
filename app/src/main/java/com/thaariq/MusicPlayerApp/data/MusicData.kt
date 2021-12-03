package com.thaariq.MusicPlayerApp.data

import com.thaariq.musicplayerapp.R

object MusicData {
    private val musicnames = arrayOf(
    "Abdurrahman Al Ossi",
    "Abu Yahya Badrussalam Lc",
    "Fatih Seferagic",
    "Khalid Basalamah Lc MA",
    "Mishary Rasyid",
    "Muzammil Hasballah",
    "Syafiq Riza Basalamah",
    "Syaikh Shalih bin Al Fauzan",
    "Muhammad Taha Al Junayd",
    "Yasser Al Dossary",
    "Yazid bin Abdul Qadir Jawas",
    "Abdullah Zaen")

    private val musicalbums = arrayOf(
    "Surah Al Qari'ah",
    "Hukum Cryptocurrency",
    "Surah Al Mujadalah",
    "Nikmat Allah Yang Terlupakan",
    "Surah Al Baqarah",
    "Surah Ar Rahman",
    "Keluarga Bahagia Dengan Sunnah Rasul",
    "Tafsir Ibnu Katsir",
    "Surah Al Fath",
    "Surah Ali Imran",
    "Kitab Tauhid part 5",
    "Puasa Sunnah")

    private val musiccover = intArrayOf(
        R.drawable.abdurrahman,
        R.drawable.badrussalam,
        R.drawable.fatih,
        R.drawable.khalid,
        R.drawable.mishary,
        R.drawable.muzammil,
        R.drawable.syafiq,
        R.drawable.syaikh,
        R.drawable.taha,
        R.drawable.yasser,
        R.drawable.yazid,
        R.drawable.zaen
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