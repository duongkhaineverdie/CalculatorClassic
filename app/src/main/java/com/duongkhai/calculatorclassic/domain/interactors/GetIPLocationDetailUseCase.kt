package com.duongkhai.calculatorclassic.domain.interactors

import com.duongkhai.calculatorclassic.data.model.IPLocation
import com.duongkhai.calculatorclassic.data.repository.IRepository
import domain.interactors.type.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetIPLocationDetailUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, IPLocation>(dispatcher) {
    override suspend fun block(param: Unit): IPLocation = repository.getDetailIPLocation()
}