package com.dkneverd.calculatorclassic.domain.interactors

import com.dkneverd.calculatorclassic.data.model.IPLocation
import com.dkneverd.calculatorclassic.data.repository.IRepository
import domain.interactors.type.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetIPLocationDetailUseCase(
    private val repository: com.dkneverd.calculatorclassic.data.repository.IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, com.dkneverd.calculatorclassic.data.model.IPLocation>(dispatcher) {
    override suspend fun block(param: Unit): com.dkneverd.calculatorclassic.data.model.IPLocation = repository.getDetailIPLocation()
}