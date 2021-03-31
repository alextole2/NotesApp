package com.personal.notes.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.personal.notes.R
import com.personal.notes.data.Note
import kotlinx.android.synthetic.main.note_item.view.*

class NotesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bindView(item: Note) {
        with(view) {
            tv_note.text = item.text
        }
    }
}

class NotesAdapter(private val data: MutableList<Note> = mutableListOf()) : RecyclerView.Adapter<NotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) = holder.bindView(data[position])

    override fun getItemCount(): Int = data.size

    fun add(items: List<Note>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun add(item: Note) {
        data.add(item)
        notifyDataSetChanged()
    }

    fun remove(item: Note) {
        data.remove(item)
        notifyDataSetChanged()
    }
}