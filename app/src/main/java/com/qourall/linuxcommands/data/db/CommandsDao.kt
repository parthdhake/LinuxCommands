package com.qourall.linuxcommands.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CommandsDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun save(command: CommandsData)

    @Query("SELECT * FROM Linux_Commands_Table ORDER BY _id ASC")
    suspend fun load(): List<CommandsData>


    @Query("SELECT * FROM Linux_Commands_Table WHERE favourite_boolean = 1 ORDER BY _id ASC")
    suspend fun loadFavourite(): List<CommandsData>

    @Query("SELECT DISTINCT(command_category) FROM Linux_Commands_Table ORDER BY _id ASC")
    fun category(): LiveData<List<String>>

    @Query("UPDATE Linux_Commands_Table SET favourite_boolean = 0 WHERE _id = :tid")
    suspend fun makeUnfavourite(tid: Int): Int

    @Query("UPDATE Linux_Commands_Table SET favourite_boolean = 1 WHERE _id = :tid")
    suspend fun makefavourite(tid: Int): Int

//    @Query("SELECT * FROM Linux_Commands_Table WHERE command_category = '% :category %' ORDER BY _id ASC")
//    fun categoryWiseCommands(category: String): LiveData<List<CommandsData>>


}