package com.duongkhai.calculatorclassic.domain.interactors

import com.duongkhai.calculatorclassic.data.repository.IRepository
import com.duongkhai.calculatorclassic.data.model.RemoteConfigs
import domain.interactors.type.BaseUseCaseFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetRemoteConfigUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCaseFlow<Unit, RemoteConfigs>(dispatcher) {
    override suspend fun build(param: Unit): Flow<RemoteConfigs> = repository.getConfigs()
}