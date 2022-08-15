package com.vshyrochuk.topcharts.data.network

import com.vshyrochuk.topcharts.domain.network.response.ChartsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ChartsApi {
    @GET("api/v2/{country}/music/most-played/{limit}/albums.json")
    suspend fun getCharts(@Path("country") country: String, @Path("limit") limit: Int): ChartsResponse
}
