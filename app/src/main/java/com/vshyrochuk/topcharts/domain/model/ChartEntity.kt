package com.vshyrochuk.topcharts.domain.model

data class ChartEntity(
    val remoteId: String,
    val albumName: String,
    val albumThumbnail: String,
    val artistName: String,
    val genres: List<Genre>,
    val releaseData: String,
    val copyright: String,
    val url: String
) {
    data class Genre(
        val id: String,
        val name: String
    )

    fun getResizedImageThumbnail(width: Int = 300, height: Int = 300): String {
        val paths = albumThumbnail.split("/").toMutableList()
        paths.removeLast()
        paths.add("${width}x$height.jpg")
        return paths.joinToString("/")
    }
}

