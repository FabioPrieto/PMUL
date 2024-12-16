package com.example.notesaplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.notesaplication.R
import com.example.notesaplication.data.Note
import com.example.notesaplication.data.notes

@Composable
fun NotesAplication(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { NotesAplicationTopAppBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addNote") },
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

                        navController.navigate("noteDetail/${note.hashCode()}")

                    }
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesAplicationTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size)),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Text(
                    text = "Notas",
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var isDisabled by remember { mutableStateOf(false) }

    Card(modifier = modifier.clickable { onClick() }) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (isDisabled) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f) else MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth(0.7f)
                )
                Checkbox(
                    checked = isDisabled,
                    onCheckedChange = { isChecked ->
                        isDisabled = isChecked
                    },
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small))
                )
                IconButton(
                    onClick = {
                        notes.filterNot { (note.title == note.title) }
                    },
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                ) {
                    Icon(
                        imageVector = Icons.Default.Close, // Usamos el icono de la "X"
                        contentDescription = "Eliminar Nota",
                        tint = MaterialTheme.colorScheme.error, // Puedes usar un color de error para la "X"
                        modifier = Modifier.size(250.dp)
                    )
                }
            }

            //Text(text = note.description)
            // Aquí puedes agregar más campos como la fecha si lo deseas
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
