package com.qourall.linuxcommands.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.qourall.linuxcommands.data.db.CommandsDao
import com.qourall.linuxcommands.data.db.CommandsDatabase
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application) : AndroidViewModel(application) {

    private var commandsDao: CommandsDao = CommandsDatabase.invoke(application).getCommandsDao()

    fun favourite(id: Int) {
        viewModelScope.launch {
            commandsDao.makefavourite(id)
        }
    }
    fun unfavourite(id: Int) {
        viewModelScope.launch {
            commandsDao.makeUnfavourite(id)
        }
    }

}