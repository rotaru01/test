package com.daniel.rpncalculator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RpnCalculatorScreen(viewModel: RpnCalculatorViewModel = viewModel()) {
    val display = viewModel.display.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = display,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonRow(numbers = listOf("1", "2", "3"), onClick = viewModel::onNumberInput)
            ButtonRow(numbers = listOf("4", "5", "6"), onClick = viewModel::onNumberInput)
            ButtonRow(numbers = listOf("7", "8", "9"), onClick = viewModel::onNumberInput)
            ButtonRow(numbers = listOf("0"), onClick = viewModel::onNumberInput)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { viewModel.onOperatorInput("+") }) { Text("+") }
                Button(onClick = { viewModel.onOperatorInput("-") }) { Text("-") }
                Button(onClick = { viewModel.onOperatorInput("*") }) { Text("*") }
                Button(onClick = { viewModel.onOperatorInput("/") }) { Text("/") }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { viewModel.onEnterPressed() }) { Text("Enter") }
                Button(onClick = { viewModel.onClear() }) { Text("Clear") }
            }
        }
    }
}

@Composable
fun ButtonRow(numbers: List<String>, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (number in numbers) {
            Button(
                onClick = { onClick(number) },
                modifier = Modifier.weight(1f)
            ) {
                Text(number)
            }
        }
    }
}
