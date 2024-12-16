package com.example.notesaplication.ui

import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.snapshots.snapshotFlow
import androidx.lifecycle.ViewModel
import com.example.notesaplication.data.Note
import com.example.notesaplication.data.notes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel() {

    // Estado que almacena las notas
    private val _notes = mutableStateOf<List<Note>>(emptyList())
    val notes: List<Note> get() = _notes.value

    // Función para agregar una nueva nota
    fun addNote(note: Note) {
        //_notes.add(note)
    }

    // Función para eliminar una nota por su índice
    fun removeNote(note: Note) {
        // Filtrar la lista para eliminar la nota
        _notes.value = _notes.value.filterNot { it == note }
    }

}
