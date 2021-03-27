package com.example.mytodo

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() , INoteRVAdapter {


    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NoteRVAdaptor(this,this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer { List->
            List?.let {
                adapter.updateList(it as ArrayList<Note>)
            }
        })
    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, " ${note.text} Deleted" , Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {

        val input: EditText = findViewById(R.id.input)
        val noteText= input.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNote(Note(noteText))
            Toast.makeText(this, " ${noteText} Inserted" , Toast.LENGTH_LONG).show()

        }

    }
}