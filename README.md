# 📱 CountriesApp

CountriesApp es una aplicación Android desarrollada en **Kotlin** utilizando **Jetpack Compose** y **arquitectura MVVM**, que permite explorar países del mundo, navegar entre pantallas y sentar las bases para funcionalidades como búsqueda, favoritos y detalles por país.

Este proyecto fue desarrollado con **fines educativos**, aplicando buenas prácticas del desarrollo Android moderno.

---

## 🚀 Tecnologías utilizadas

- **Kotlin**
- **Jetpack Compose** (UI declarativa)
- **Material 3**
- **Navigation Compose**
- **Arquitectura MVVM**
- **Gradle Kotlin DSL**
- **Git & GitHub**

---

## 🧱 Arquitectura del proyecto (MVVM)

El proyecto sigue el patrón **MVVM (Model – View – ViewModel)** para mantener el código organizado, escalable y fácil de mantener.

### 🔹 Model
Contiene las clases de datos del dominio, por ejemplo:
- `Country`

### 🔹 View
Pantallas desarrolladas con Jetpack Compose:
- `HomeScreen`
- `CountriesScreen`
- `DetailScreen` (estructura preparada)

Incluye componentes reutilizables como:
- `CountryCard`

### 🔹 ViewModel
Encargado de:
- Manejar el estado de la interfaz
- Preparar los datos para la UI
- Separar la lógica de negocio de la vista

---

## 🗂️ Estructura del proyecto


`text
app/
└── src/main/java/com/example/countriesapp/
    ├── data/
    │   ├── remote/
    │   └── repository/
    ├── domain/
    │   └── model/
    │       └── Country.kt
    ├── ui/
    │   ├── components/
    │   │   └── CountryCard.kt
    │   ├── navigation/
    │   │   └── AppNav.kt
    │   ├── screens/
    │   │   ├── home/
    │   │   │   └── HomeScreen.kt
    │   │   ├── countries/
    │   │   └── detail/
    │   └── theme/
    └── MainActivity.kt


---

## 🧭 Navegación

La navegación entre pantallas se maneja con **Navigation Compose** desde:


ui/navigation/AppNav.kt


Este archivo define:
- La pantalla inicial
- Las rutas de navegación
- El flujo entre pantallas

---

## 🎨 Interfaz de usuario

La UI está desarrollada completamente con **Jetpack Compose**:

- Diseño moderno con **Material 3**
- Uso de `Scaffold`, `TopAppBar`
- Componentes reutilizables
- Código declarativo y limpio

---

## 🧪 Control de versiones (Git)

Se utilizó **Git** para el control de versiones y **GitHub** como repositorio remoto.

### Commits realizados:
- **Commit inicial del proyecto**
- **Agrega HomeScreen y actualiza navegación**

Esto permite:
- Volver a estados anteriores del proyecto
- Mantener un historial claro de cambios
- Trabajar de forma profesional

---

## ▶️ Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/TU_USUARIO/CountriesApp.git

Abre el proyecto en Android Studio

Sincroniza Gradle

Ejecuta la app en:

Emulador Android

O dispositivo físico con Depuración USB

📌 Estado del proyecto

✔️ Proyecto configurado correctamente
✔️ Arquitectura MVVM aplicada
✔️ Navegación funcional
