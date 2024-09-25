package com.example.atividadexp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atividadexp2.ui.theme.AtividadeXP2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jogadores()
        }
    }
}

@Composable
fun Jogadores() {

    val jogadoresIds = listOf(1, 2, 3, 4, 5, 6)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(jogadoresIds) { jogadorId ->
            Jodagor(jogadorId)
        }
    }
}

@Composable
fun Jodagor(jogadorId: Int) {

    var nome by remember { mutableStateOf("") }
    var level by remember { mutableIntStateOf(1) }
    var equipamento by remember { mutableIntStateOf(0) }
    var modificadores by remember { mutableIntStateOf(0) }
    var poder by remember { mutableIntStateOf(0) }

    poder = level + equipamento + modificadores

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jogador $jogadorId", fontSize = 18.sp, modifier = Modifier.padding(8.dp))

        TextField(
            value = nome,
            onValueChange = { nome = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Button(onClick = { level = (level - 1).coerceAtLeast(1) }) { Text("-") }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Level: $level")
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { level = (level + 1).coerceAtMost(10) }) { Text("+") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Button(onClick = { equipamento = (equipamento - 1).coerceAtLeast(0) }) { Text("-") }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Equipamento: $equipamento")
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { equipamento = (equipamento + 1).coerceAtMost(99) }) { Text("+") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Button(onClick = { modificadores = (modificadores - 1).coerceAtLeast(-10) }) { Text("-") }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Modificadores: $modificadores")
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { modificadores = (modificadores + 1).coerceAtMost(10) }) { Text("+") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Poder: $poder", fontSize = 18.sp, modifier = Modifier.padding(8.dp))
    }
}
