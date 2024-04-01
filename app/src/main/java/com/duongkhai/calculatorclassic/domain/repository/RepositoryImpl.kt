package com.duongkhai.calculatorclassic.domain.repository

import com.duongkhai.calculatorclassic.data.model.IPLocation
import com.duongkhai.calculatorclassic.data.repository.IRepository
import com.duongkhai.calculatorclassic.data.repository.RemoteConfigRepo
import com.truongvim.snakegame.data.repository.IPLocationApi

class RepositoryImpl(
    private val remoteConfigRepo: RemoteConfigRepo,
    private val ipLocationApi: IPLocationApi,
): IRepository {
    override suspend fun getDetailIPLocation(): IPLocation = ipLocationApi.getDetailIPLocation()
    override fun initConfigs() = remoteConfigRepo.initConfigs()

    override fun getConfigs() = remoteConfigRepo.getConfigs()
}