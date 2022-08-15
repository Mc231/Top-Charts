package com.vshyrochuk.topcharts.data.db.mapper

import com.vshyrochuk.topcharts.data.db.RealmChartEntity
import com.vshyrochuk.topcharts.domain.model.ChartEntity

fun RealmChartEntity.toDomain() = ChartEntity(
    remoteId = this.remoteId,
    albumName = this.albumName,
    albumThumbnail = this.albumThumbnail,
    artistName = this.artistName,
    genres = this.genres.map { ChartEntity.Genre(it.remoteId, it.name) },
    releaseData = this.releaseDate,
    copyright = copyright,
    url = this.url
)
