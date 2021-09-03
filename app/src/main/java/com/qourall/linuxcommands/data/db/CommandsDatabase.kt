package com.qourall.linuxcommands.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CommandsData::class], version = 1)
abstract class CommandsDatabase : RoomDatabase() {
    abstract fun getCommandsDao() : CommandsDao

    companion object{
        @Volatile
        private var instance: CommandsDatabase? = null
        private val LOCK = Any()
        private const val db = "database.db"

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            CommandsDatabase::class.java, db)
            .createFromAsset("linux_commands.db")
            .build()

    }

}
