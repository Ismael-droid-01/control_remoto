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
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.control_remoto.ui.theme.*
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.buttonBorder(
    color: Color,
    width: Dp = 2.dp,
    shape: Shape = CircleShape
) = this.border(width, color, shape)

@Composable
fun RemoteControlUI(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val bleServer = (context as? MainActivity)?.bleServer

    fun showMessage(message: String) {
        Toast.makeText(context, "Acción: $message", Toast.LENGTH_SHORT).show()
    }

    val isDarkTheme = isSystemInDarkTheme()
    val stopBackground = if (isDarkTheme) StopColorDark else StopColorLight
    val stopIconColor = if (isDarkTheme) OnStopColorDark else OnStopColorLight

    Box(
        modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
            .padding(16.dp)
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ) {

        // 🔴 Botón Power (color rojo)
        val powerColor = MaterialTheme.colorScheme.errorContainer
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(80.dp)
            ) {
                IconButton(
                    onClick = {
                        showMessage("Power")
                        bleServer?.sendText("Power")
                    },
                    modifier = Modifier
                        .background(powerColor, CircleShape)
                        .fillMaxSize()
                        .buttonBorder(powerColor)
                ) {
                    Icon(
                        Icons.Filled.PowerSettingsNew,
                        contentDescription = "Power",
                        tint = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        }

        // 🔵 Bluetooth y WiFi
        val bluetoothColor = MaterialTheme.colorScheme.secondaryContainer
        val wifiColor = MaterialTheme.colorScheme.tertiaryContainer
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(175.dp, Alignment.CenterHorizontally)
        ) {
            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(64.dp)
            ) {
                IconButton(
                    onClick = {
                        showMessage("Bluetooth")
                        bleServer?.sendText("Bluetooth")
                    },
                    modifier = Modifier
                        .background(bluetoothColor, CircleShape)
                        .fillMaxSize()
                        .buttonBorder(bluetoothColor)
                ) {
                    Icon(
                        Icons.Filled.Bluetooth,
                        contentDescription = "Bluetooth",
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }

            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(64.dp)
            ) {
                IconButton(
                    onClick = {
                        showMessage("WiFi")
                        bleServer?.sendText("WiFi")
                    },
                    modifier = Modifier
                        .background(wifiColor, CircleShape)
                        .fillMaxSize()
                        .buttonBorder(wifiColor)
                ) {
                    Icon(
                        Icons.Filled.Wifi,
                        contentDescription = "WiFi",
                        tint = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }
        }

        // ⬅️➡️ Giro Izq y Der (color primario)
        val giroColor = MaterialTheme.colorScheme.primaryContainer
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 6.dp, bottom = 50.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(64.dp)
            ) {
                IconButton(
                    onClick = {
                        showMessage("GiroIzq")
                        bleServer?.sendText("GiroIzq")
                    },
                    modifier = Modifier
                        .background(giroColor, CircleShape)
                        .fillMaxSize()
                        .buttonBorder(giroColor)
                ) {
                    Icon(
                        Icons.Filled.Undo,
                        contentDescription = "GiroIzq",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(64.dp)
            ) {
                IconButton(
                    onClick = {
                        showMessage("GiroDer")
                        bleServer?.sendText("GiroDer")
                    },
                    modifier = Modifier
                        .background(giroColor, CircleShape)
                        .fillMaxSize()
                        .buttonBorder(giroColor)
                ) {
                    Icon(
                        Icons.Filled.Redo,
                        contentDescription = "GiroDer",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        // 🔼🔽 Arriba y Abajo (color primario)
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(64.dp)
            ) {
                IconButton(
                    onClick = {
                        showMessage("Arriba")
                        bleServer?.sendText("Arriba")
                    },
                    modifier = Modifier
                        .background(giroColor, CircleShape)
                        .fillMaxSize()
                        .buttonBorder(giroColor)
                ) {
                    Icon(
                        Icons.Filled.ArrowUpward,
                        contentDescription = "Arriba",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Surface(
                shape = CircleShape,
                shadowElevation = 8.dp,
                modifier = Modifier.size(64.dp)
            ) {
                IconButton(
                    onClick = {
                        showMessage("Abajo")
                        bleServer?.sendText("Abajo")
                    },
                    modifier = Modifier
                        .background(giroColor, CircleShape)
                        .fillMaxSize()
                        .buttonBorder(giroColor)
                ) {
                    Icon(
                        Icons.Filled.ArrowDownward,
                        contentDescription = "Abajo",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        // ⛔ Botón Stop con color propio
        Surface(
            shape = CircleShape,
            shadowElevation = 12.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 130.dp)
                .size(72.dp)
        ) {
            IconButton(
                onClick = {
                    showMessage("Stop")
                    bleServer?.sendText("Stop")
                },
                modifier = Modifier
                    .background(stopBackground, CircleShape)
                    .fillMaxSize()
                    .buttonBorder(stopBackground)
            ) {
                Icon(
                    Icons.Filled.Stop,
                    contentDescription = "Stop",
                    tint = stopIconColor
                )
            }
        }

        // 💡 Botón Luces (color primario)
        Surface(
            shape = CircleShape,
            shadowElevation = 8.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .size(64.dp)
        ) {
            IconButton(
                onClick = {
                    showMessage("Luces")
                    bleServer?.sendText("Luces")
                },
                modifier = Modifier
                    .background(giroColor, CircleShape)
                    .fillMaxSize()
                    .buttonBorder(giroColor)
            ) {
                Icon(
                    Icons.Filled.Lightbulb,
                    contentDescription = "Luces",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}
