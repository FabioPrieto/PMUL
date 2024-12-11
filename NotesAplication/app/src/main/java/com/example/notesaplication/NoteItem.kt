package com.example.notesaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.notesaplication.data.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var isDisabled by remember { mutableStateOf(false) }

    Card(modifier = modifier,) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = note.title, style = MaterialTheme.typography.bodyLarge,modifier = Modifier.fillMaxWidth(0.7f))
                Checkbox(
                    checked = isDisabled,
                    onCheckedChange = { isChecked ->
                        isDisabled = isChecked
                    },
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small))
                )
                IconButton(
                    onClick = {
                        // Acción para eliminar la nota (aquí puedes agregar la lógica de eliminación)
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
