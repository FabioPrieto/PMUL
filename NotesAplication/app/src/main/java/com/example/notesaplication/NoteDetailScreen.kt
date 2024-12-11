package com.example.notesaplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notesaplication.data.Note
import com.example.notesaplication.data.notes

@Composable
fun NoteDetailScreen(noteId: Int) {
    // Buscar la nota por su ID (en este caso usando el hashCode)
    val note = notes.find { it.hashCode() == noteId }

    note?.let {
        // Mostrar los detalles de la nota
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Título: ${it.title}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Descripción: ${it.description}")
            Text(text = "Fecha: ${it.date}")
            // Aquí puedes agregar más información de la nota si lo deseas
        }
    }
}
