package com.vshyrochuk.topcharts.domain.network.response

import com.google.gson.annotations.SerializedName

data class ChartsResponse(
    @SerializedName("feed") val feed: Feed
) {
    data class Feed(
        @SerializedName("copyright") val copyright: String,
        @SerializedName("results")
        val result: List<ResultItem>
    ) {
        data class ResultItem(
            @SerializedName("id") val id: String,
            @SerializedName("name") val name: String,
            @SerializedName("artworkUrl100") val artwork: String,
            @SerializedName("artistName") val artistName: String,
            @SerializedName("genres") val genres: List<Genre>,
            @SerializedName("url") val url: String,
            @SerializedName("releaseDate") val releaseDate: String
        ) {
            data class Genre(
                @SerializedName("genreId") val id: String,
                @SerializedName("name") val name: String
            )
        }
    }
}
