package com.example.notesaplication
/*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesaplication.ui.theme.NotesAplicationTheme
import com.example.notesaplication.data.Note
import com.example.notesaplication.data.notes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotesAplication(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NotesAplication(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            NotesAplicationTopAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Acción para agregar una nueva nota */ },
                modifier = Modifier
                    .padding(16.dp) // Espaciado respecto a los bordes
                    //.align(Alignment.BottomEnd), // Alineación en la esquina inferior derecha
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar Nota",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            items(notes) {
                NoteItem(
                    note = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

/**
 * Composable that displays a list item containing a dog icon and their information.
 *
 * @param note contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    )


    var isDisabled by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .animateContentSize(animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
                )
                .background(color)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                NoteTitle(note.title,isDisabled = isDisabled)
                Checkbox(
                    checked = isDisabled,
                    onCheckedChange = { isChecked ->
                        isDisabled = isChecked // Cuando el checkbox se marca, se deshabilita el NoteTitle
                    },
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small))
                )
            }

        }

    }
}

/**
 * Composable that displays a dog's name and age.
 *
 * @param Title is the resource ID for the string of the dog's name
 * @param isDisabled is the Int that represents the dog's age
 * @param modifier modifiers to set to this composable
 */
@Composable
fun NoteTitle(
    Title: String,
    isDisabled: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = Title,
            style = MaterialTheme.typography.headlineSmall,
            color = if (isDisabled) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f) else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))
                .fillMaxWidth(0.9f)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesAplicationTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotesAplicationTheme {
        NotesAplication()
    }
}
 */

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesaplication.data.Note
import com.example.notesaplication.ui.AddNoteDialog
import com.example.notesaplication.ui.theme.NotesAplicationTheme
import com.example.notesaplication.ui.NoteDetailScreen
import com.example.notesaplication.ui.NoteViewModel
import com.example.notesaplication.ui.NotesAplication
import com.example.notesaplication.ui.NotesAplicationPreview

class MainActivity : ComponentActivity() {
    private val noteViewModel: NoteViewModel by viewModels() // Usar el ViewModel
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAplicationTheme {
                val navController = rememberNavController() // Crear un NavController
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Configurar el NavHost y las rutas
                    NavHost(
                        navController = navController,
                        startDestination = "notesList", // Pantalla inicial
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("notesList") {
                            NotesAplication(navController) // Pasa el NavController
                        }
                        composable("noteDetail/{noteId}") { backStackEntry ->
                            // Obtener el ID de la nota desde la ruta
                            val noteId = backStackEntry.arguments?.getString("noteId")?.toInt()
                            noteId?.let {
                                NoteDetailScreen(
                                    noteId = it,
                                    onBack = { navController.popBackStack() },
                                    onEdit = { /* Navegar a la pantalla de edición */ },
                                    onDelete = {
                                        navController.popBackStack()
                                        noteViewModel.deleteNote(

                                            noteViewModel.notes.find { note -> note.hashCode() == noteId }!!

                                        )
                                    }
                                ) // Mostrar los detalles de la nota
                            }
                        }
                        composable("addNote") {
                            AddNoteDialog(
                                onDismiss = {navController.popBackStack()},
                                onAdd = { title, description ->
                                    navController.popBackStack()

                                    noteViewModel.addNote(Note(title, description))
                                }
                            )
                        }
                    }
                }

                /*
                NotesAplication(navController)
                 */
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAplicationTheme {
        // Usamos una versión sin NavController para previsualización
        //NotesAplicationPreview()
    }
}
