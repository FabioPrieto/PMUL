package com.example.notesaplication

import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Checkbox
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.unit.dp
import com.example.notesaplication.data.Note
import com.example.notesaplication.data.notes
import com.example.notesaplication.ui.theme.NotesAplicationTheme

@Composable
fun NotesAplication(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { NotesAplicationTopAppBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción para agregar una nueva nota */ },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Nota")
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(notes) { note ->
                NoteItem(
                    note = note,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                    onClick = {
                        // Navegar a la pantalla de detalle pasando el ID de la nota
                        navController.navigate("noteDetail/${note.hashCode()}")
                    }
                )
            }
        }
    }
}
@Composable
fun NotesAplicationPreview(
    modifier: Modifier = Modifier
) {
    // Usamos un Scaffold básico sin navegación para previsualizar el contenido
    Scaffold(
        topBar = { NotesAplicationTopAppBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción para agregar una nueva nota */ },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Nota")
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(notes) { note ->
                NoteItem(
                    note = note,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                    onClick = {
                        // Navegación deshabilitada para previsualización
                    }
                )
            }
        }
    }
}
