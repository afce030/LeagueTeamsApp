package com.cardona.leagueteamsapp.frameworks.room

import com.cardona.data.persistence.ITeamsPersistenceDataSource
import com.cardona.domain.entities.Team
import com.cardona.leagueteamsapp.frameworks.dataMappers.ITeamsMapper
import com.cardona.leagueteamsapp.frameworks.room.databases.LeaguesDatabase
import com.cardona.leagueteamsapp.frameworks.room.entities.TeamLocalEntity
import io.reactivex.Single
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.suspendCoroutine

class TeamsPersistentDataSource @Inject constructor(
    private val teamsMapper: ITeamsMapper,
    private val leaguesDatabase: LeaguesDatabase
) : ITeamsPersistenceDataSource, CoroutineScope {

    @Transient
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + IO

    override fun saveTeamsLocally(teams: List<Team>) {
        val localEntities = teamsMapper.mapDomaintoLocalEntities(teams)

        launch {
            leaguesDatabase.leaguesDAO().insertTeams(*localEntities.toTypedArray())
        }
    }

    override fun getTeamsLocal(leagueName: String) =
        leaguesDatabase.leaguesDAO().getTeamsFromLocal("Spain")
            .map {
                teamsMapper.mapLocalEntitytoDomain(it)
            }

}
