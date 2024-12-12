package com.example.notesaplication.ui

import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.snapshots.snapshotFlow
import androidx.lifecycle.ViewModel
import com.example.notesaplication.data.Note
import com.example.notesaplication.data.notes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel() {
    // Estado que almacena las notas
    private val _notes = mutableStateListOf(*notes.toTypedArray()) // Copia de las notas iniciales
    val notes: List<Note> get() = _notes

    // Función para agregar una nueva nota
    fun addNote(note: Note) {
        _notes.add(note)
    }

    // Función para eliminar una nota por su índice
    fun deleteNote(note: Note) {
        _notes.remove(note)
    }

    // Si necesitas observar el estado de las notas de manera reactiva
    //val notesState = snapshotFlow { notes }.collectAsState(initial = emptyList())
}
