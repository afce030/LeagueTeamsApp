package com.cardona.data.remoteSources

import com.cardona.domain.entities.Team

interface ITeamsDataSource {
    fun getTeams(leagueName: String, callback: (List<Team>)->(Unit))
}
