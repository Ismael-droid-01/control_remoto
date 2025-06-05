# Instalación de la Aplicación Control Remoto

## 📋 Requisitos Previos
- Dispositivo Android con Bluetooth activado
- Archivo `ControlRemoto.apk` (de fuente confiable)
- ESP32 con firmware del carrito instalado
- Conexión Bluetooth disponible en ambos dispositivos

## ⚙️ Pasos de Instalación

### 1. Transferir el archivo APK
Copie el archivo `ControlRemoto.apk` a su Android mediante:
- Conexión USB
- Correo electrónico
- Google Drive u otro servicio en la nube
- Cualquier método de transferencia

### 2. Habilitar instalaciones externas
1. Vaya a **Configuración → Seguridad** (o **Privacidad**)
2. Active:
   - **"Orígenes desconocidos"** (Android ≤7.0)
   - **"Instalar aplicaciones desconocidas"** (Android 8.0+)
   > *Seleccione su gestor de archivos cuando se solicite*

### 3. Instalar la aplicación
1. Abra su gestor de archivos y ubique `ControlRemoto.apk`
2. Toque el archivo → **Instalar**
3. Espere a que complete la instalación
4. Seleccione:
   - **Abrir** para iniciar inmediatamente
   - **Listo** para usar después

### 4. Primera conexión
1. Active Bluetooth en su Android y ESP32
2. Abra la aplicación Control Remoto
3. Verifique:
   - Respuesta de los controles
   - Conexión estable con el carrito

## ⚠️ Nota de Seguridad
Durante la instalación, Android mostrará advertencias porque la aplicación no viene de Google Play. Esto es normal en instalaciones manuales.  

**Puede ignorarlas con seguridad si:**
- El APK fue generado por usted o su equipo
- Descargó el archivo de una fuente confiable
- Verificó que no es una versión modificada

> **Consejo:** Desactive "Orígenes desconocidos" tras la instalación para mayor seguridad.
