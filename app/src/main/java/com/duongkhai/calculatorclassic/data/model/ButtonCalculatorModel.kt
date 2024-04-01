package com.duongkhai.calculatorclassic.data.model

import androidx.compose.ui.graphics.Color
import com.duongkhai.calculatorclassic.presentation.CalculatorAction
import com.duongkhai.calculatorclassic.utils.ButtonType

data class ButtonCalculatorModel(
    val textButton: String = "0",
    val calculatorAction: CalculatorAction = CalculatorAction.Number(0),
    val colorButton: Color = Color(0xFFFFFFFF)
)
