package com.example.superheroe.data

import com.google.gson.annotations.SerializedName

data class Image (
    @SerializedName("url") val url: String,
) {}