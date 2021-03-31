package com.personal.notes.data

import androidx.lifecycle.MutableLiveData

class Database {

    private val database: MutableLiveData<MutableList<Note>> = MutableLiveData()

    fun insertNote(note: Note) {
        var list = database.value
        list?.add(note) ?: run {
            list = mutableListOf()
            list?.add(note)
        }
        database.postValue(list)
    }

    fun getNotes() = database
}