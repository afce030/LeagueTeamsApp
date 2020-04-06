package com.cardona.data.repositories

import com.cardona.data.persistence.ITeamsPersistenceDataSource
import com.cardona.data.remoteSources.ITeamsDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class TeamsRepositoryTest {

    private lateinit var teamsDataSource: ITeamsDataSource
    private lateinit var teamsPersistenceDataSource: ITeamsPersistenceDataSource

    lateinit var teamsRepository: TeamsRepository
    private var leagueName: String = ""

    @Before
    fun initMocks(){
        teamsDataSource = Mockito.mock(ITeamsDataSource::class.java)
        teamsPersistenceDataSource = Mockito.mock(ITeamsPersistenceDataSource::class.java)

        teamsRepository =
                TeamsRepository(teamsDataSource, teamsPersistenceDataSource)
    }

    @Test
    fun `assert that teams are requested`() {
        `given the league name`()
        `when teams are requested`()
        `then, TeamsDataSource performs an api request`()
    }

    @Test
    fun `assert that teams are saved in the local database`() {
        `given the league name`()
        `when teams are requested`()
        `then, domain entities are saved locally`()
    }

    @Test
    fun `assert that teams are returned from the local database`() {
        `given the league name`()
        `when teams are requested`()
        `then, teams are requested from the local database`()
    }

    private fun `given the league name`() {
        leagueName = "Spain"
    }

    private fun `when teams are requested`() = runBlocking{
        teamsRepository.getTeamsFromAPi(leagueName)
    }

    private fun `then, TeamsDataSource performs an api request`() {
        teamsDataSource.getTeams(leagueName){}
    }

    private fun `then, domain entities are saved locally`() {
        teamsDataSource.getTeams(leagueName){
            Mockito.verify(teamsPersistenceDataSource).saveTeamsLocally(Mockito.anyList())
        }
    }

    private fun `then, teams are requested from the local database`() {
        teamsDataSource.getTeams(leagueName){
            Mockito.verify(teamsPersistenceDataSource).getTeamsLocal(leagueName)
        }
    }

}