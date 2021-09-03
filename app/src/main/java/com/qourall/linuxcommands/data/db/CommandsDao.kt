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
    fun load(): LiveData<List<CommandsData>>

    @Query("SELECT DISTINCT(command_category) FROM Linux_Commands_Table  ORDER BY _id ASC")
    fun category(): LiveData<List<String>>

}