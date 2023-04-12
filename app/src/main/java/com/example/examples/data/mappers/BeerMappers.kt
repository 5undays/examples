package com.example.examples.data.mappers

import com.example.examples.data.local.BeerEntity
import com.example.examples.data.remote.BeerDto
import com.example.examples.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url,
        tagline = tagline
    )
}

fun BeerEntity.toBeer() : Beer {
    return Beer(
        id = id,
        name = name,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl,
        tagline = tagline
    )
}