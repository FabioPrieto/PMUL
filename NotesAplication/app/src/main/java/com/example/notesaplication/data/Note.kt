package com.example.notesaplication.data

import androidx.compose.ui.graphics.Color
import java.util.Date

data class Note(
    val title: String,
    val description: String,
    val date: Date, // Usamos java.util.Date
    val color: Color
)

val notes = listOf(
    Note(
        title = "Compra semanal",
        description = "Recordar comprar frutas, leche y huevos",
        date = Date(2024 - 1900, 9, 14, 9, 30), // Fecha específica (año debe restar 1900)
        color = Color(255, 0, 0) // Rojo
    ),
    Note(
        title = "Reunión de trabajo",
        description = "Preparar la presentación de avances del proyecto",
        date = Date(2024 - 1900, 9, 15, 14, 0),
        color = Color(0, 255, 0) // Verde
    ),
    Note(
        title = "Cita médica",
        description = "Revisión anual con el doctor",
        date = Date(2024 - 1900, 9, 16, 11, 0),
        color = Color(0, 0, 255) // Azul
    ),
    Note(
        title = "Cena con amigos",
        description = "Reservar mesa en el restaurante italiano",
        date = Date(2024 - 1900, 9, 17, 20, 30),
        color = Color(255, 255, 0) // Amarillo
    ),
    Note(
        title = "Curso online",
        description = "Completar el módulo 5 del curso de Kotlin",
        date = Date(2024 - 1900, 9, 18, 18, 0),
        color = Color(255, 165, 0) // Naranja
    )
)

