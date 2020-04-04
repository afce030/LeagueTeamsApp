package com.cardona.domain.useCases

import com.cardona.domain.repositories.ITeamsRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetLeagueTeamsTest {

    lateinit var getLeagueTeams: GetLeagueTeams
    lateinit var teamsRepository: ITeamsRepository

    var leagueName: String? = null

    @Before
    fun initMocks() {
        teamsRepository = Mockito.mock(ITeamsRepository::class.java)
        getLeagueTeams = GetLeagueTeams(teamsRepository)
    }

    @Test
    fun `assert that teams are requested`() {

        `given the league name`()

        `when the user request for the teams`()

        `then, teams are requested from the APi`()
    }

    private fun `given the league name`() {
        leagueName = "Spain"
    }

    private fun `when the user request for the teams`() {
        getLeagueTeams.invoke(leagueName = leagueName)
    }

    private fun `then, teams are requested from the APi`() {
        Mockito.verify(teamsRepository).getTeamsFromAPi(leagueName = leagueName)
    }

}