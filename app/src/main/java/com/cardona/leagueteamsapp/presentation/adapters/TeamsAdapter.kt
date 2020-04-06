package com.cardona.leagueteamsapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cardona.domain.entities.Team
import com.cardona.leagueteamsapp.R
import com.cardona.leagueteamsapp.presentation.fragments.TeamsListFragmentDirections
import kotlinx.android.synthetic.main.team_item.view.*

class TeamsAdapter(
    private val context: Context
) : RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>(){

    private lateinit var navController: NavController
    private var items = listOf<Team>()

    fun setItems(items: List<Team>){
        this.items = items
        notifyDataSetChanged()
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        return TeamsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        Glide.with(context).load(items[position].badge.badge)
            .into(holder.itemView.ivTeamBadgeTeamsListFragment)
        holder.itemView.tvTeamNameTeamsListFragment.text = items[position].name.name
        holder.itemView.tvTeamDescTeamsListFragment.text = items[position].description

        val action = TeamsListFragmentDirections.actionTeamsListFragmentToTeamDescriptionFragment(
            teamName = items[position].name.name ?: "",
            teamDescription = items[position].description ?: "",
            teamYear = items[position].foundationYear.year ?: "",
            teamBadge = items[position].badge.badge ?: ""
        )

        holder.itemView.setOnClickListener {
            navController.navigate(action)
        }

    }

    class TeamsViewHolder(view: View): RecyclerView.ViewHolder(view)
}
