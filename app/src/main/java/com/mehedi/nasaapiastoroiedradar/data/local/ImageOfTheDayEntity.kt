package com.mehedi.nasaapiastoroiedradar.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_of_the_day")
data class ImageOfTheDayEntity(
    @PrimaryKey val date: String,
    val explanation: String?,
    val hdurl: String?,
    val mediaType: String?,
    val serviceVersion: String?,
    val title: String?,
    val url: String?
)
