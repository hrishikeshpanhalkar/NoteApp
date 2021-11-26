package com.example.noteapp.features.domain.usecase

import com.example.noteapp.features.domain.model.InvalidNoteException
import com.example.noteapp.features.domain.model.Note
import com.example.noteapp.features.domain.repository.NoteRepository

class AddNote (
    private val repository: NoteRepository
    ) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}