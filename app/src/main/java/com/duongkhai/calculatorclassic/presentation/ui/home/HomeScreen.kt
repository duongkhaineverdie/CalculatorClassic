package com.duongkhai.calculatorclassic.presentation.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.duongkhai.calculatorclassic.data.model.ButtonCalculatorModel
import com.duongkhai.calculatorclassic.presentation.ui.component.ButtonCalculator
import com.duongkhai.calculatorclassic.presentation.ui.theme.CalculatorClassicTheme
import com.duongkhai.calculatorclassic.utils.ButtonType
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val homeViewModel: HomeViewModel = koinViewModel()
    val uiState by homeViewModel.uiState.collectAsState()
    HomeScreen(
        modifier = Modifier.fillMaxSize(),
        listButtonCalculatorModel = uiState.buttonList,
        onClickButton = {/* no-op */ }
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    listButtonCalculatorModel: List<ButtonCalculatorModel>,
    onClickButton: (ButtonCalculatorModel) -> Unit,
) {
    val zero = ButtonCalculatorModel("0", ButtonType.ZERO)
    val dot = ButtonCalculatorModel(".", ButtonType.DOT)
    val result = ButtonCalculatorModel("=", ButtonType.RESULT)
    ConstraintLayout(
        modifier = modifier,
    ) {
        val (screen, keyboard) = createRefs()
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Red)
            .constrainAs(screen) {
                top.linkTo(parent.top)
                bottom.linkTo(keyboard.top)
                height = Dimension.fillToConstraints
            }) {
        }
        Column(
            modifier = Modifier.constrainAs(keyboard) {
                bottom.linkTo(parent.bottom)
            }
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 4)
            ) {
                items(
                    listButtonCalculatorModel,
                    key = { buttonCalculator -> buttonCalculator.buttonType }) { buttonCalculatorModel ->
                    ButtonCalculator(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp),
                        buttonCalculatorModel = buttonCalculatorModel,
                        onClick = { onClickButton(it) })
                }
            }
            Row(Modifier.fillMaxWidth()) {
                ButtonCalculator(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(2f),
                    buttonCalculatorModel = zero,
                    onClick = { onClickButton(it) })
                ButtonCalculator(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                    buttonCalculatorModel = dot,
                    onClick = { onClickButton(it) })
                ButtonCalculator(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                    buttonCalculatorModel = result,
                    onClick = { onClickButton(it) })
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview() {
    CalculatorClassicTheme {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            listButtonCalculatorModel = buttonList,
            onClickButton = {/* no-op */ }
        )
    }
}

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