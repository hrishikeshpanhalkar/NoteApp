package com.example.noteapp.di

import android.app.Application
import androidx.room.Room
import com.example.noteapp.features.data.data_source.NoteDatabase
import com.example.noteapp.features.data.repository.NoteRepositoryImpl
import com.example.noteapp.features.domain.repository.NoteRepository
import com.example.noteapp.features.domain.usecase.AddNote
import com.example.noteapp.features.domain.usecase.DeleteNote
import com.example.noteapp.features.domain.usecase.GetNotes
import com.example.noteapp.features.domain.usecase.NoteUseCases
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}