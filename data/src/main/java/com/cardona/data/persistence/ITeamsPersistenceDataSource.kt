package com.cardona.data.persistence

import com.cardona.domain.entities.Team
import io.reactivex.Single

interface ITeamsPersistenceDataSource {
    fun saveTeamsLocally(teams: List<Team>)
    fun getTeamsLocal(leagueName: String): Single<List<Team>>
}
