package com.qourall.linuxcommands.ui.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.qourall.linuxcommands.data.db.CommandsDao
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.data.db.CommandsDatabase
import kotlinx.coroutines.launch

class CommandsViewModel(application: Application) : AndroidViewModel(application) {

    private var commandsDao: CommandsDao = CommandsDatabase.invoke(application).getCommandsDao()

    private val _commandDetails = MutableLiveData<List<CommandsData>>()
    val commandsDetails : LiveData<List<CommandsData>>
        get() = _commandDetails


    fun getCommandsDetails() {
        viewModelScope.launch {
           _commandDetails.value = commandsDao.load()
        }
    }

}