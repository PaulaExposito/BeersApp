package com.example.beersapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Beer(
    val brand: String,

    val name: String,

    val style: String,

    val alcohol: String
) : Parcelable

