package com.cardona.domain.useCases

import com.cardona.domain.entities.Team
import com.cardona.domain.repositories.ITeamsRepository
import io.reactivex.Single

class GetLeagueTeams(private val teamsRepository: ITeamsRepository) {

    suspend fun invoke(leagueName: String) : Single<List<Team>> {
        return teamsRepository.getTeamsFromAPi(leagueName)
    }

}