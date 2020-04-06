package com.cardona.leagueteamsapp.presentation.viewCommands.wrappers

import android.view.View
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.Command
import javax.inject.Inject

class CommandInvoker @Inject constructor(){

    private var command: Command? = null

    fun setViewCommand(command: Command){
        this.command = command
    }

    fun start(view: View){
        command?.execute(view)
    }

}
