package com.qourall.linuxcommands.data.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Linux_Commands_Table")
data class CommandsData(
    @PrimaryKey(autoGenerate = true) val _id: Int,
    val command_name: String,
    val command_category: String,
    val command_description: String,
    val command_quick_ref: String,
    val command_syntax: String,
    val command_option: String,
    val command_example: String,
    val command_remarks: String,
    var favourite_boolean: Int,
) : Parcelable