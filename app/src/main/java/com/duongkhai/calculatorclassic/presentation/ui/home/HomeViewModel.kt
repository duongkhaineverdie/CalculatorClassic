package com.duongkhai.calculatorclassic.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.duongkhai.calculatorclassic.data.model.ButtonCalculatorModel
import com.duongkhai.calculatorclassic.utils.ButtonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

}

data class HomeUiState(
    val isProcessing: Boolean = false,
    val buttonList: List<ButtonCalculatorModel> = listOf(
        ButtonCalculatorModel("C", ButtonType.C),
        ButtonCalculatorModel("DEL", ButtonType.DELETE),
        ButtonCalculatorModel("%", ButtonType.PERCENT),
        ButtonCalculatorModel("/", ButtonType.DIVIDE),
        ButtonCalculatorModel("7", ButtonType.SEVEN),
        ButtonCalculatorModel("8", ButtonType.EIGHT),
        ButtonCalculatorModel("9", ButtonType.NINE),
        ButtonCalculatorModel("x", ButtonType.MULTI),
        ButtonCalculatorModel("4", ButtonType.FOUR),
        ButtonCalculatorModel("5", ButtonType.FIVE),
        ButtonCalculatorModel("6", ButtonType.SIX),
        ButtonCalculatorModel("-", ButtonType.SUB),
        ButtonCalculatorModel("1", ButtonType.ONE),
        ButtonCalculatorModel("2", ButtonType.TWO),
        ButtonCalculatorModel("3", ButtonType.THREE),
        ButtonCalculatorModel("+", ButtonType.PLUS),
    )
)