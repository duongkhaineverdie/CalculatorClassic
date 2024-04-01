package com.duongkhai.calculatorclassic.data.model

import com.duongkhai.calculatorclassic.utils.ButtonType

data class ButtonCalculatorModel(
    val textButton: String = "0",
    val buttonType: ButtonType = ButtonType.ZERO,
)
