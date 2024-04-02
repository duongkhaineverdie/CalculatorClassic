package com.truongvim.snakegame.data.repository

import com.dkneverd.calculatorclassic.data.model.IPLocation
import retrofit2.http.GET

interface IPLocationApi {
    @GET("json")
    suspend fun getDetailIPLocation(): com.dkneverd.calculatorclassic.data.model.IPLocation
}