package com.qourall.linuxcommands.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.qourall.linuxcommands.data.db.CommandsDao
import com.qourall.linuxcommands.data.db.CommandsDatabase

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private var commandsDao: CommandsDao = CommandsDatabase.invoke(application).getCommandsDao()

    fun getCategory(): LiveData<List<String>>{
        return commandsDao.category()
    }

}