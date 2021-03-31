package com.personal.notes.ui.activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.personal.notes.R
import com.personal.notes.data.Note
import com.personal.notes.ui.adapters.NotesAdapter
import com.personal.notes.viewmodels.NotesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_ui.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private val notesVieModel: NotesViewModel by viewModel()
    private val notesAdapter: NotesAdapter by lazy {
        NotesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        //Initialize recycler view
        recycler_view.adapter = notesAdapter
        recycler_view.layoutManager = LinearLayoutManager(context)

        //Observe view model changes
        notesVieModel.getNotes()?.observe(this, { data ->
            data?.let {
                if (data.isEmpty()) {
                    Toast.makeText(context, R.string.empty_list, Toast.LENGTH_LONG).show()
                } else {
                    notesAdapter.add(it)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add_action) {
            dialogAddNote()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogAddNote() {
        val layout = LayoutInflater.from(context).inflate(R.layout.dialog_ui, null, false)
        val inputNote = layout.input_note
        AlertDialog.Builder(context)
                .setView(layout)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(R.string.save) { _, _ ->
                    //Save a note
                    val note = Note(0, inputNote.text.toString())
                    notesVieModel.save(note)
                }
                .create()
                .show()
    }
}