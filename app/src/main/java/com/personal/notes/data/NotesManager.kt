package com.personal.notes.data

import androidx.lifecycle.MutableLiveData

class NotesManager {

    private val data: MutableLiveData<MutableList<Note>> = MutableLiveData()

    fun getNotes() = data

    fun addNote(note: Note) {
        var list = data.value
        list?.add(note) ?: run {
            list = mutableListOf()
            list?.add(note)
        }
        data.postValue(list)
    }
}