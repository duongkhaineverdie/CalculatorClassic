package com.duongkhai.calculatorclassic.data.repository

import com.duongkhai.calculatorclassic.data.model.IPLocation
import com.duongkhai.calculatorclassic.data.model.RemoteConfigs
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getDetailIPLocation(): IPLocation
    fun initConfigs()

    fun getConfigs(): Flow<RemoteConfigs>
}