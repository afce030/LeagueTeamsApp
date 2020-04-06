package com.cardona.leagueteamsapp.presentation.viewCommands

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cardona.domain.entities.Team
import com.cardona.leagueteamsapp.presentation.adapters.TeamsAdapter
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.Command

class PopulateRecyclerView(
    private val recyclerViewId: Int,
    private val teamsAdapter: TeamsAdapter,
    private val items: List<Team>
) : Command {

    private var recycleView: RecyclerView? = null

    override fun execute(view: View) {
        recycleView = view.findViewById(recyclerViewId)
        recycleView.apply {
            this?.adapter = teamsAdapter
            this?.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        }

        teamsAdapter.setNavController(view.findNavController())
        teamsAdapter.setItems(items)

    }

}
