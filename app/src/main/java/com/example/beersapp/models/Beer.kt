package com.example.beersapp.models

import com.google.gson.annotations.SerializedName

data class Beer (
    @SerializedName("id")
    val id: Long,

    @SerializedName("uid")
    val uid: String,

    @SerializedName("brand")
    val brand: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("style")
    val style: String,

    @SerializedName("hop")
    val hop: String,

    @SerializedName("yeast")
    val yeast: String,

    @SerializedName("malts")
    val malts: String,

    @SerializedName("ibu")
    val ibu: String,

    @SerializedName("alcohol")
    val alcohol: String,

    @SerializedName("blg")
    val blg: String
)