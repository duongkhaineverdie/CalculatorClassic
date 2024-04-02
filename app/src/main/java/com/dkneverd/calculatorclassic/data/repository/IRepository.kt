package com.dkneverd.calculatorclassic.data.repository

import com.dkneverd.calculatorclassic.data.model.IPLocation
import com.dkneverd.calculatorclassic.data.model.RemoteConfigs
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getDetailIPLocation(): com.dkneverd.calculatorclassic.data.model.IPLocation
    fun initConfigs()

    fun getConfigs(): Flow<com.dkneverd.calculatorclassic.data.model.RemoteConfigs>
}