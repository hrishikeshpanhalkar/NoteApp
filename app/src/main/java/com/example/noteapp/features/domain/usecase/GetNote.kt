package com.example.noteapp.features.domain.usecase

import com.example.noteapp.features.domain.model.Note
import com.example.noteapp.features.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}