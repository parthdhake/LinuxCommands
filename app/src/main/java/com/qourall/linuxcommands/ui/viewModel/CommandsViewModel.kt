package com.qourall.linuxcommands.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.qourall.linuxcommands.data.db.CommandsDao
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.data.db.CommandsDatabase

class CommandsViewModel(application: Application) : AndroidViewModel(application) {

    private var commandsDao: CommandsDao = CommandsDatabase.invoke(application).getCommandsDao()

    fun getCommandsDetails(): LiveData<List<CommandsData>> {
        return commandsDao.load()
    }

}