package com.example.control_remoto.ui

import com.example.control_remoto.MainActivity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun RemoteControlUI(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val bleServer = (context as? MainActivity)?.bleServer

    fun showMessage(message: String) {
        Toast.makeText(context, "Acción: $message", Toast.LENGTH_SHORT).show()
    }

    Box(modifier = modifier.fillMaxSize().padding(16.dp).padding(WindowInsets.navigationBars.asPaddingValues())) {

        // 🔼 Top Row
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(
                onClick = {
                    showMessage("Bluetooth")
                    bleServer?.sendText("Bluetooth")
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer, CircleShape).size(64.dp)
            ) {
                Icon(Icons.Filled.Bluetooth, contentDescription = "Bluetooth", tint = MaterialTheme.colorScheme.onSecondaryContainer)
            }

            IconButton(
                onClick = {
                    showMessage("Power")
                    bleServer?.sendText("Power")
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.errorContainer, CircleShape).size(64.dp)
            ) {
                Icon(Icons.Filled.PowerSettingsNew, contentDescription = "Power", tint = MaterialTheme.colorScheme.onErrorContainer)
            }

            IconButton(
                onClick = {
                    showMessage("WiFi")
                    bleServer?.sendText("WiFi")
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.tertiaryContainer, CircleShape).size(64.dp)
            ) {
                Icon(Icons.Filled.Wifi, contentDescription = "WiFi", tint = MaterialTheme.colorScheme.onTertiaryContainer)
            }
        }

        // ⬅️➡️ Giro Izq y Der
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 8.dp, bottom = 60.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            IconButton(
                onClick = {
                    showMessage("GiroIzq")
                    bleServer?.sendText("GiroIzq")
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer, CircleShape).size(64.dp)
            ) {
                Icon(Icons.Filled.Undo, contentDescription = "GiroIzq", tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }

            IconButton(
                onClick = {
                    showMessage("GiroDer")
                    bleServer?.sendText("GiroDer")
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer, CircleShape).size(64.dp)
            ) {
                Icon(Icons.Filled.Redo, contentDescription = "GiroDer", tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }

        // 🔼🔽 Arriba y Abajo
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    showMessage("Arriba")
                    bleServer?.sendText("Arriba")
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer, CircleShape).size(64.dp)
            ) {
                Icon(Icons.Filled.ArrowUpward, contentDescription = "Arriba", tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }

            IconButton(
                onClick = {
                    showMessage("Abajo")
                    bleServer?.sendText("Abajo")
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer, CircleShape).size(64.dp)
            ) {
                Icon(Icons.Filled.ArrowDownward, contentDescription = "Abajo", tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }

        // ⛔ Botón Stop (subido un poco)
        IconButton(
            onClick = {
                showMessage("Stop")
                bleServer?.sendText("Stop")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 130.dp)
                .background(MaterialTheme.colorScheme.errorContainer, CircleShape)
                .size(72.dp)
        ) {
            Icon(Icons.Filled.Stop, contentDescription = "Stop", tint = MaterialTheme.colorScheme.onErrorContainer)
        }

        // 💡 Botón Luces (debajo del Stop)
        IconButton(
            onClick = {
                showMessage("Luces")
                bleServer?.sendText("Luces")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                .size(64.dp)
        ) {
            Icon(Icons.Filled.Lightbulb, contentDescription = "Luces", tint = MaterialTheme.colorScheme.onPrimaryContainer)
        }
    }
}
