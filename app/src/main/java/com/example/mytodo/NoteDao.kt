package com.example.mytodo

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // if we dont  want to add similar tsuffs
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from note_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>> //live data upon the rapper of list which help to show live updates

}