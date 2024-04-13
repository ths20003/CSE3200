package com.example.lab5project.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RadioStation (
    val id: Int,
    @StringRes val radioStationName: Int,
    @StringRes val url: Int,
    @DrawableRes val imageResourceID: Int
)