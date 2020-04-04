package com.cardona.domain.useCases

import com.cardona.domain.repositories.ITeamsRepository

class GetLeagueTeams(private val teamsRepository: ITeamsRepository) {

    fun invoke(leagueName: String?) {
        teamsRepository.getTeamsFromAPi(leagueName)
    }

}