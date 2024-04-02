package com.dkneverd.calculatorclassic.data.model

import androidx.compose.ui.graphics.Color
import com.dkneverd.calculatorclassic.presentation.CalculatorAction
import com.dkneverd.calculatorclassic.utils.ButtonType

data class ButtonCalculatorModel(
    val textButton: String = "0",
    val calculatorAction: CalculatorAction = CalculatorAction.Number(0),
    val colorButton: Color = Color(0xFFFFFFFF)
)
