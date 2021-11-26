package com.example.noteapp.features.domain.usecase

import com.example.noteapp.features.domain.model.Note
import com.example.noteapp.features.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}