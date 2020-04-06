package com.cardona.data.repositories

import com.cardona.data.persistence.ITeamsPersistenceDataSource
import com.cardona.data.remoteSources.ITeamsDataSource
import com.cardona.domain.entities.Team
import com.cardona.domain.repositories.ITeamsRepository
import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamsRepository @Inject constructor(
    private val teamsDataSource: ITeamsDataSource,
    private val teamsPersistentDataSource: ITeamsPersistenceDataSource
): ITeamsRepository {

    override suspend fun getTeamsFromAPi(leagueName: String): Single<List<Team>> {

        teamsDataSource.getTeams(leagueName){ teams ->

            CoroutineScope(Default).launch {

                withContext(IO){
                    teamsPersistentDataSource.saveTeamsLocally(teams)
                }

            }

        }

        return teamsPersistentDataSource.getTeamsLocal(leagueName)

    }

}