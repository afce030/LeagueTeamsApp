package com.cardona.leagueteamsapp.presentation.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.cardona.leagueteamsapp.BaseApp

import com.cardona.leagueteamsapp.R
import com.cardona.leagueteamsapp.presentation.viewCommands.ShowTeamDescription
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.CommandInvoker
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TeamDescriptionFragment : Fragment() {

    @Inject
    lateinit var commandInvoker: CommandInvoker

    private val argsproofs: TeamDescriptionFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        (activity?.application as BaseApp).getComponent()?.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layoutView = inflater.inflate(R.layout.fragment_team_description, container, false)

        commandInvoker.setViewCommand(
            ShowTeamDescription(
                name = argsproofs.teamName,
                description = argsproofs.teamDescription,
                year = argsproofs.teamYear,
                badge = argsproofs.teamBadge
            )
        )

        commandInvoker.start(layoutView)

        return layoutView
    }


}
