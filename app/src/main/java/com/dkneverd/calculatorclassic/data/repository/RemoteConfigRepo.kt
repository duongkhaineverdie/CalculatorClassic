package com.dkneverd.calculatorclassic.data.repository

import com.dkneverd.calculatorclassic.data.model.RemoteConfigs
import kotlinx.coroutines.flow.Flow


/**
 * @Author Mbuodile Obiosio
 * Twitter: @cazewonder
 * Remote Configuration Repository interface
 */
interface RemoteConfigRepo {

    fun initConfigs()

    fun getConfigs(): Flow<com.dkneverd.calculatorclassic.data.model.RemoteConfigs>
}