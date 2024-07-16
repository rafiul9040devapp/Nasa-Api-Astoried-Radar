package com.mehedi.nasaapiastoroiedradar.utils

import com.mehedi.nasaapiastoroiedradar.data.local.ImageOfTheDayEntity
import com.mehedi.nasaapiastoroiedradar.data.models.ResponseImageOfTheDay

object ImageOfTheDayMapper {

    fun toEntity(response: ResponseImageOfTheDay): ImageOfTheDayEntity {
        return ImageOfTheDayEntity(
            date = response.date ?: "", // Assuming date is non-null and used as a primary key
            explanation = response.explanation,
            hdurl = response.hdurl,
            mediaType = response.mediaType,
            serviceVersion = response.serviceVersion,
            title = response.title,
            url = response.url
        )
    }

    fun toResponse(entity: ImageOfTheDayEntity): ResponseImageOfTheDay {
        return ResponseImageOfTheDay(
            date = entity.date,
            explanation = entity.explanation,
            hdurl = entity.hdurl,
            mediaType = entity.mediaType,
            serviceVersion = entity.serviceVersion,
            title = entity.title,
            url = entity.url
        )
    }
}
