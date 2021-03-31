package com.personal.notes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.personal.notes.data.Database
import com.personal.notes.data.Note
import com.personal.notes.data.NotesManager

class NotesViewModel : ViewModel() {

    private val database = Database()
    private val notesManager = NotesManager(database)
    private var notes: MutableLiveData<MutableList<Note>>? = null

    fun getNotes(): LiveData<MutableList<Note>>? {
        if (notes == null) {
            notes = notesManager.getNotes()
        }
        return notes
    }

    fun save(note: Note) {
        notesManager.addNote(note)
    }
}