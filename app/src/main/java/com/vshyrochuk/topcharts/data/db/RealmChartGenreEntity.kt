package com.vshyrochuk.topcharts.data.db

import com.vshyrochuk.topcharts.domain.model.ChartEntity
import io.realm.kotlin.types.RealmObject

class RealmChartGenreEntity : RealmObject {
    var remoteId: String = ""
    var name: String = ""
}

fun ChartEntity.Genre.toRealmGenre(): RealmChartGenreEntity {
    return RealmChartGenreEntity().apply {
        remoteId = this@toRealmGenre.id
        name = this@toRealmGenre.name
    }
}
