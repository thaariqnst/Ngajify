package com.thaariq.MusicPlayerApp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Music(
    var name : String = "",
    var album : String = "",
    var cover : Int = 0
):Parcelable
