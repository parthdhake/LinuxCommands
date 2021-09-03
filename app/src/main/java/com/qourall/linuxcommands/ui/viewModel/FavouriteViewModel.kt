package com.qourall.linuxcommands.ui.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.qourall.linuxcommands.data.db.CommandsDao
import com.qourall.linuxcommands.data.db.CommandsData
import com.qourall.linuxcommands.data.db.CommandsDatabase
import kotlinx.coroutines.launch

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {

    private var commandsDao: CommandsDao = CommandsDatabase.invoke(application).getCommandsDao()


    private var _commandDetails = MutableLiveData<List<CommandsData>>()
    val commandDetails : LiveData<List<CommandsData>>
        get() = _commandDetails

    fun getAllFavourites() {
        viewModelScope.launch {
            _commandDetails.value = commandsDao.loadFavourite()
        }
    }
}