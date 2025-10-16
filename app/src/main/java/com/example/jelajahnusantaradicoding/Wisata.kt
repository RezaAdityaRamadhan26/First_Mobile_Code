package com.example.jelajahnusantaradicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val nama: String,
    val deskripsiSingkat: String,
    val deskripsiPanjang: String,
    val foto: Int
) : Parcelable