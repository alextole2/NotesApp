package com.personal.notes.data

class NotesManager(private val database: Database) {

    fun getNotes() = database.getNotes()

    fun addNote(note: Note) {
        database.insertNote(note)
    }
}