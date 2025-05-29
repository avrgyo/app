package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val usuario = User(
            nombreCompleto = "Claudia Tona",
            edad = 31,
            fechaNacimiento = "22/02/1994",
            direccion = "Tijuana, BC",
            nombreUsuario = "@claudiatona",
            cuentaVerificada = true
        )

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PerfilUsuario(usuario = usuario)
                }
            }
        }
    }
}

// Composable principal mejorado
@Composable
fun PerfilUsuario(usuario: User, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = usuario.nombreCompleto,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = usuario.nombreUsuario,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))

                Divider()

                InfoRow("🎂 Edad", "${usuario.edad}")
                InfoRow("📅 Nacimiento", usuario.fechaNacimiento)
                InfoRow("📍 Dirección", usuario.direccion)
                InfoRow("✔️ Verificada", if (usuario.cuentaVerificada) "Sí" else "No")
            }
        }
    }
}

// Reutilizable para mostrar ítem + dato
@Composable
fun InfoRow(icono: String, dato: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = icono, style = MaterialTheme.typography.bodyLarge)
        Text(text = dato, style = MaterialTheme.typography.bodyLarge)
    }
}

// Vista previa
@Preview(showBackground = true)
@Composable
fun PerfilUsuarioPreview() {
    val usuarioDemo = User(
        nombreCompleto = "Claudia Tona",
        edad = 31,
        fechaNacimiento = "22/02/1994",
        direccion = "Tijuana, BC",
        nombreUsuario = "@claudiatona",
        cuentaVerificada = true
    )

    MyApplicationTheme {
        PerfilUsuario(usuarioDemo)
    }
}
