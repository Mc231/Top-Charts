package com.vshyrochuk.topcharts.data.db

import com.vshyrochuk.topcharts.domain.model.ChartEntity
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class RealmChartEntity: RealmObject {
    var remoteId: String = ""
    var albumName: String = ""
    var albumThumbnail: String = ""
    var artistName: String = ""
    var genres: RealmList<RealmChartGenreEntity> = realmListOf()
    var releaseDate: String = ""
    var copyright: String = ""
    var url: String = ""
}

fun ChartEntity.toRealmChartEntity(): RealmChartEntity {
    return RealmChartEntity().apply {
        remoteId = this@toRealmChartEntity.remoteId
        albumName = this@toRealmChartEntity.albumName
        albumThumbnail = this@toRealmChartEntity.albumThumbnail
        artistName = this@toRealmChartEntity.artistName
        genres = this@toRealmChartEntity.genres.map { it.toRealmGenre() }.toRealmList()
        releaseDate = this@toRealmChartEntity.releaseData
        copyright = this@toRealmChartEntity.copyright
        url = this@toRealmChartEntity.url
    }
}
