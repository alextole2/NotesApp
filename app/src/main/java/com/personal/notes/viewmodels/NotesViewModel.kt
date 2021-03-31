package com.personal.notes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.personal.notes.data.Note
import com.personal.notes.data.NotesManager

class NotesViewModel(private val notesManager: NotesManager) : ViewModel() {
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