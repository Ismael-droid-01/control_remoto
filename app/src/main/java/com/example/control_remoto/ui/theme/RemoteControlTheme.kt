package com.example.control_remoto.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme

private val LightColors = lightColorScheme(
    primary = Color(0xFFD9A800),             // Amarillo mostaza cálido
    onPrimary = Color.Black,
    primaryContainer = Color(0xFFF1E08A),    // Amarillo pastel suave
    onPrimaryContainer = Color(0xFF5D4300),

    secondary = Color(0xFF1976D2),           // Azul vibrante (Bluetooth)
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFBBDEFB),
    onSecondaryContainer = Color(0xFF0D47A1),

    tertiary = Color(0xFFBDBDBD),            // Gris medio neutro (WiFi)
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFFEEEEEE),   // Gris claro (fondo del botón WiFi)
    onTertiaryContainer = Color(0xFF424242), // Gris oscuro (ícono WiFi)

    error = Color(0xFF388E3C),               // Verde bosque (Power)
    onError = Color.White,
    errorContainer = Color(0xFFC8E6C9),
    onErrorContainer = Color(0xFF1B5E20),

    background = Color(0xFFF5F5F5),
    onBackground = Color(0xFF212121),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF212121)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFB58800),              // Amarillo mostaza oscuro
    onPrimary = Color.Black,
    primaryContainer = Color(0xFFD9A800),
    onPrimaryContainer = Color(0xFF5D4300),

    secondary = Color(0xFF1565C0),           // Azul oscuro (Bluetooth)
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF90CAF9),
    onSecondaryContainer = Color(0xFF0D47A1),

    tertiary = Color(0xFF757575),            // Gris medio
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFF424242),   // Gris más oscuro (WiFi)
    onTertiaryContainer = Color(0xFFE0E0E0), // Gris claro para ícono

    error = Color(0xFF2E7D32),               // Verde Power
    onError = Color.White,
    errorContainer = Color(0xFF81C784),
    onErrorContainer = Color(0xFF1B5E20),

    background = Color(0xFF121212),
    onBackground = Color(0xFFF5F5F5),
    surface = Color(0xFF212121),
    onSurface = Color(0xFFF5F5F5)
)

// COLORES PERSONALIZADOS PARA STOP
val StopColorLight = Color(0xFFFFCDD2)        // Rojo claro
val OnStopColorLight = Color(0xFFB71C1C)      // Ícono rojo oscuro

val StopColorDark = Color(0xFFEF9A9A)         // Rojo más tenue en modo oscuro
val OnStopColorDark = Color(0xFFFFEBEE)       // Casi blanco para ícono

@Composable
fun RemoteControlTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}
