package com.example.noteapp.features.presentation.notes

import com.example.noteapp.features.domain.model.Note
import com.example.noteapp.features.domain.util.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
