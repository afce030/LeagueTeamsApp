package com.cardona.data.remoteSources

import com.cardona.data.remoteSources.dto.TeamDTO

interface ITeamsDataSource {
    fun getTeams(leagueName: String?, callback: (List<TeamDTO>)->(Unit))
}
