package com.duongkhai.calculatorclassic.data.repository

import com.duongkhai.calculatorclassic.data.model.RemoteConfigs
import kotlinx.coroutines.flow.Flow


/**
 * @Author Mbuodile Obiosio
 * Twitter: @cazewonder
 * Remote Configuration Repository interface
 */
interface RemoteConfigRepo {

    fun initConfigs()

    fun getConfigs(): Flow<RemoteConfigs>
}