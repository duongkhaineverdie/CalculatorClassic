package com.dkneverd.calculatorclassic.presentation.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel
import com.dkneverd.calculatorclassic.presentation.CalculatorAction
import com.dkneverd.calculatorclassic.presentation.CalculatorOperation
import com.dkneverd.calculatorclassic.utils.ButtonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorUiState())

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> state = CalculatorUiState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Percent -> number1 % number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if(!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

data class CalculatorUiState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val calculatorButtons: List<com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel> = listOf(
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "C",
            CalculatorAction.Clear,
            Color(0xFFA5B2C5)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "⌫",
            CalculatorAction.Delete,
            Color(0xFFA5B2C5)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "%",
            CalculatorAction.Operation(CalculatorOperation.Percent),
            Color(0xFFA5B2C5)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "/",
            CalculatorAction.Operation(CalculatorOperation.Divide),
            Color(0xFFC9641A)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "7",
            CalculatorAction.Number(7),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "8",
            CalculatorAction.Number(8),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "9",
            CalculatorAction.Number(9),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "*",
            CalculatorAction.Operation(CalculatorOperation.Multiply),
            Color(0xFFC9641A)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "4",
            CalculatorAction.Number(4),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "5",
            CalculatorAction.Number(5),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "6",
            CalculatorAction.Number(6),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "-",
            CalculatorAction.Operation(CalculatorOperation.Subtract),
            Color(0xFFC9641A)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "1",
            CalculatorAction.Number(1),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "2",
            CalculatorAction.Number(2),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "3",
            CalculatorAction.Number(3),
            Color(0xFFBABFC9)
        ),
        com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
            "+",
            CalculatorAction.Operation(CalculatorOperation.Add),
            Color(0xFFC9641A)
        ),
    )
)