package com.duongkhai.calculatorclassic.presentation.ui.component

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duongkhai.calculatorclassic.data.model.ButtonCalculatorModel
import com.duongkhai.calculatorclassic.utils.bounceClick
import com.duongkhai.calculatorclassic.utils.innerShadow

@Composable
fun ButtonCalculator(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(30.dp),
    fontSize: TextUnit = 30.sp,
    buttonCalculatorModel: ButtonCalculatorModel,
    onClick: (ButtonCalculatorModel) -> Unit,
    aspectRatio: Float = 1f,
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Card(
            modifier = if (aspectRatio != 0f) {
                Modifier
                    .bounceClick()
                    .aspectRatio(aspectRatio)
                    .fillMaxSize()
                    .clickable(
                        onClick = { onClick(buttonCalculatorModel) },
                        indication = null,
                        interactionSource = remember {
                            MutableInteractionSource()
                        }
                    )
            } else {
                Modifier
                    .bounceClick()
                    .fillMaxSize()
                    .clickable(
                        onClick = { onClick(buttonCalculatorModel) },
                        indication = null,
                        interactionSource = remember {
                            MutableInteractionSource()
                        }
                    )
            },
            shape = shape,
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 20.dp
            ),
            border = BorderStroke(
                width = 1.dp,
                brush = Brush.linearGradient(
                    listOf(
                        Color(0x80FFFFFF),
                        Color(0x33FFFFFF),
                        Color(0x1AFFFFFF),
                        Color(0x1A000000),
                        Color(0x33000000),
                        Color(0x80000000),
                    )
                )
            ),
            colors = CardDefaults.cardColors(
                containerColor = buttonCalculatorModel.colorButton
            ),
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = buttonCalculatorModel.textButton,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = fontSize,
                )
            }
        }

    }
}

@Preview(
    name = "ButtonCalculator",
    widthDp = 400,
    heightDp = 400,
    showBackground = true,
    backgroundColor = 0xFFE5E6EA
)
@Composable
private fun PreviewButtonCalculator() {
    ButtonCalculator(
        modifier = Modifier.fillMaxSize(),
        buttonCalculatorModel = ButtonCalculatorModel(),
        onClick = {/* no-op */ }
    )
}