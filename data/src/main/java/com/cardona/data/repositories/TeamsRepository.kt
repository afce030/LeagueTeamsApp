package com.cardona.data.repositories

import com.cardona.data.mappers.TeamsMapper
import com.cardona.data.persistence.ITeamsPersistenceDataSource
import com.cardona.data.remoteSources.ITeamsDataSource
import com.cardona.domain.repositories.ITeamsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamsRepository(
    private val teamsDataSource: ITeamsDataSource,
    private val teamsPersistentDataSource: ITeamsPersistenceDataSource
): ITeamsRepository {

    override fun getTeamsFromAPi(leagueName: String) {

        teamsDataSource.getTeams(leagueName){ teams ->

            val teamsLocalEntities = TeamsMapper.mapDTOtoLocalEntity(teams)

            CoroutineScope(Default).launch {

                withContext(IO){
                    teamsPersistentDataSource.saveTeamsLocally(teamsLocalEntities)
                }

                val teamsEntities = withContext(IO){
                    teamsPersistentDataSource.getTeamsLocal(leagueName)
                }

                TeamsMapper.mapLocalEntitytoDomain(teamsEntities)

            }

        }
    }

}