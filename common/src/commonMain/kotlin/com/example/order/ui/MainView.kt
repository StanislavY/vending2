package com.example.order.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val state by mainViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Button(
            onClick = { mainViewModel.onConnect() },
            modifier = Modifier.height(100.dp).width(200.dp)
        ) {
            Text(
                text = state.connectButtonText
            )
        }

        TextField(
            value = state.input,
            onValueChange = { mainViewModel.onInputChange(it) },
            label = { Text("Номер ячейки:") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )

        Button(
            onClick = { mainViewModel.onOpen() },
            modifier = Modifier.height(100.dp).width(200.dp),
        ) {
            Text("Открыть")
        }
    }
}
