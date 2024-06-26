package com.dkneverd.calculatorclassic.presentation.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel
import com.dkneverd.calculatorclassic.presentation.CalculatorAction
import com.dkneverd.calculatorclassic.presentation.CalculatorOperation
import com.dkneverd.calculatorclassic.presentation.ui.component.ButtonCalculator
import com.dkneverd.calculatorclassic.presentation.ui.theme.CalculatorClassicTheme
import com.dkneverd.calculatorclassic.utils.ButtonType
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val homeViewModel: HomeViewModel = koinViewModel()
    val uiState = homeViewModel.state
    HomeScreen(
        modifier = Modifier.fillMaxSize(),
        listButtonCalculatorModel = uiState.calculatorButtons,
        onClickButton = { homeViewModel.onAction(it.calculatorAction) },
        firstNumber = uiState.number1,
        secondNumber = uiState.number2,
        operator = uiState.operation,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    listButtonCalculatorModel: List<com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel>,
    onClickButton: (com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel) -> Unit,
    firstNumber: String,
    secondNumber: String,
    operator: CalculatorOperation?
) {
    val zero = com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "0",
        CalculatorAction.Number(0),
        Color(0xFFBABFC9)
    )
    val dot = com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        ".",
        CalculatorAction.Decimal,
        Color(0xFFBABFC9)
    )
    val result = com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "=",
        CalculatorAction.Calculate,
        Color(0xFFC9641A)
    )
    ConstraintLayout(
        modifier = modifier,
    ) {
        val (screen, keyboard) = createRefs()
        Box(modifier = Modifier.constrainAs(screen) {
            top.linkTo(parent.top)
            bottom.linkTo(keyboard.top)
            height = Dimension.fillToConstraints
        }, contentAlignment = Alignment.BottomEnd) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = firstNumber + (operator?.symbol ?: "") + secondNumber,
                style = TextStyle(fontSize = 80.sp),
                textAlign = TextAlign.End,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Light,
            )
        }
        Column(
            modifier = Modifier.constrainAs(keyboard) {
                bottom.linkTo(parent.bottom)
            }
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Fixed(count = 4),
                verticalArrangement = Arrangement.Bottom,
                contentPadding = PaddingValues(top = 30.dp)
            ) {

                items(listButtonCalculatorModel) { buttonCalculatorModel ->
                    ButtonCalculator(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp),
                        buttonCalculatorModel = buttonCalculatorModel,
                        onClick = { onClickButton(it) })
                }
                item(
                    span = { GridItemSpan(4) }
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                    ) {
                        ButtonCalculator(
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(2f)
                                .fillMaxHeight(1f),
                            buttonCalculatorModel = zero,
                            onClick = { onClickButton(it) },
                            aspectRatio = 0f
                        )
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
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview() {
    CalculatorClassicTheme {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            listButtonCalculatorModel = calculatorButtons,
            onClickButton = {/* no-op */ },
            firstNumber = "2",
            secondNumber = "6",
            operator = CalculatorOperation.Add
        )
    }
}

val calculatorButtons: List<com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel> = listOf(
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel("C", CalculatorAction.Clear),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel("⌫", CalculatorAction.Delete),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "%",
        CalculatorAction.Operation(CalculatorOperation.Percent)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "/",
        CalculatorAction.Operation(CalculatorOperation.Divide)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "7",
        CalculatorAction.Number(7)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "8",
        CalculatorAction.Number(8)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "9",
        CalculatorAction.Number(9)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "*",
        CalculatorAction.Operation(CalculatorOperation.Multiply)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "4",
        CalculatorAction.Number(4)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "5",
        CalculatorAction.Number(5)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "6",
        CalculatorAction.Number(6)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "-",
        CalculatorAction.Operation(CalculatorOperation.Subtract)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "1",
        CalculatorAction.Number(1)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "2",
        CalculatorAction.Number(2)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "3",
        CalculatorAction.Number(3)
    ),
    com.dkneverd.calculatorclassic.data.model.ButtonCalculatorModel(
        "+",
        CalculatorAction.Operation(CalculatorOperation.Add)
    ),
)