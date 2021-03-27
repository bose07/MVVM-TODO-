package com.example.mytodo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdaptor(private val context: Context, private val listener: INoteRVAdapter): RecyclerView.Adapter<NoteRVAdaptor.NoteViewHolder>() {


        private val allNotes = ArrayList<Note>()


        inner class NoteViewHolder(iteamView: View)  : RecyclerView.ViewHolder(iteamView) {
            val textView: TextView = iteamView.findViewById<TextView>(R.id.text)
            val deleteButton: ImageView = iteamView.findViewById<ImageView>(R.id.deleteButton)



        }

         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
         val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent , false) )
         viewHolder.deleteButton.setOnClickListener{
                  listener.onItemClicked(allNotes[viewHolder.adapterPosition])
         }
         return viewHolder

    }



    override fun getItemCount(): Int {
              return  allNotes.size
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

          fun updatelist(newList:ArrayList<Note>){
          allNotes.clear()
           allNotes.addAll(newList)

             notifyDataSetChanged()
     }

       fun  updateList(newList: ArrayList<Note>){
              all

       }


}

interface  INoteRVAdapter {
    fun onItemClicked(note: Note)
}