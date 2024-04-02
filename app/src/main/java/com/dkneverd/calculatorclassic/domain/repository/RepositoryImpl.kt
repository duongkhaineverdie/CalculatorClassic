package com.dkneverd.calculatorclassic.domain.repository

import com.dkneverd.calculatorclassic.data.model.IPLocation
import com.dkneverd.calculatorclassic.data.repository.IRepository
import com.dkneverd.calculatorclassic.data.repository.RemoteConfigRepo
import com.truongvim.snakegame.data.repository.IPLocationApi

class RepositoryImpl(
    private val remoteConfigRepo: com.dkneverd.calculatorclassic.data.repository.RemoteConfigRepo,
    private val ipLocationApi: IPLocationApi,
): com.dkneverd.calculatorclassic.data.repository.IRepository {
    override suspend fun getDetailIPLocation(): com.dkneverd.calculatorclassic.data.model.IPLocation = ipLocationApi.getDetailIPLocation()
    override fun initConfigs() = remoteConfigRepo.initConfigs()

    override fun getConfigs() = remoteConfigRepo.getConfigs()
}