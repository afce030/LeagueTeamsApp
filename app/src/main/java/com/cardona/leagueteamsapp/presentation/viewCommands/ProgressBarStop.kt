package com.cardona.leagueteamsapp.presentation.viewCommands

import android.view.View
import android.widget.ProgressBar
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.Command

class ProgressBarStop(private val progressBarId: Int, private val backgroundId: Int) :
    Command {

    override fun execute(view: View) {
        val progressBar = view.findViewById<ProgressBar>(progressBarId)
        val background = view.findViewById<View>(backgroundId)

        background.alpha = 0.0F
        progressBar.visibility = View.GONE
    }

}
