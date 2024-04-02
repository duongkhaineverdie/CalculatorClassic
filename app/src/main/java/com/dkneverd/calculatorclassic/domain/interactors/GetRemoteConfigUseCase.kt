package com.dkneverd.calculatorclassic.domain.interactors

import com.dkneverd.calculatorclassic.data.repository.IRepository
import com.dkneverd.calculatorclassic.data.model.RemoteConfigs
import domain.interactors.type.BaseUseCaseFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetRemoteConfigUseCase(
    private val repository: com.dkneverd.calculatorclassic.data.repository.IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCaseFlow<Unit, com.dkneverd.calculatorclassic.data.model.RemoteConfigs>(dispatcher) {
    override suspend fun build(param: Unit): Flow<com.dkneverd.calculatorclassic.data.model.RemoteConfigs> = repository.getConfigs()
}