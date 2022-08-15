package com.vshyrochuk.topcharts.data.network.mapping

import com.vshyrochuk.topcharts.domain.model.ChartEntity
import com.vshyrochuk.topcharts.domain.network.response.ChartsResponse

fun ChartsResponse.toDomain() = this.feed.result.map { it.toDomain(this.feed.copyright) }

fun ChartsResponse.Feed.ResultItem.toDomain(copyright: String) = ChartEntity(
    remoteId = this.id,
    albumName = this.name,
    albumThumbnail = this.artwork,
    artistName = this.artistName,
    genres = this.genres.map { ChartEntity.Genre(it.id, it.name) },
    releaseData = this.releaseDate,
    copyright = copyright,
    url = this.url
)
