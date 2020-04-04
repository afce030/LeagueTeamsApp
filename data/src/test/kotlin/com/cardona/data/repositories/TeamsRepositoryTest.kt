package com.cardona.data.repositories

import com.cardona.data.mappers.TeamsMapper
import com.cardona.data.persistence.ITeamsPersistenceDataSource
import com.cardona.data.remoteSources.ITeamsDataSource
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class TeamsRepositoryTest {

    private lateinit var teamsDataSource: ITeamsDataSource
    private lateinit var teamsPersistenceDataSource: ITeamsPersistenceDataSource

    lateinit var teamsRepository: TeamsRepository
    private var leagueName: String? = null

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
    fun `assert that dto objects are mapped to local persistence entities`() {
        `given the league name`()

        `when teams are requested`()

        `then, dto objects are mapped to local persistence entities`()

    }

    @Test
    fun `assert that teams are saved in the local database`() {
        `given the league name`()

        `when teams are requested`()

        `then, local entities are saved`()
    }

    @Test
    fun `assert that teams are returned from the local database`() {
        `given the league name`()

        `when teams are requested`()

        `then, teams are requested from the local database`()
    }

    @Test
    fun `assert that local entities are mapped to domain entities`() {
        `given the league name`()

        `when teams are requested`()

        `then, local entities are mapped to domain entities`()
    }

    private fun `given the league name`() {
        leagueName = "Spain"
    }

    private fun `when teams are requested`() {
        teamsRepository.getTeamsFromAPi(leagueName!!)
    }

    private fun `then, TeamsDataSource performs an api request`() {
        teamsDataSource.getTeams(leagueName){}
    }

    private fun `then, dto objects are mapped to local persistence entities`() {
        teamsDataSource.getTeams(leagueName){
            TeamsMapper.mapDTOtoLocalEntity(Mockito.anyList())
        }
    }

    private fun `then, local entities are saved`() {
        teamsDataSource.getTeams(leagueName){
            Mockito.verify(teamsPersistenceDataSource).saveTeamsLocally(Mockito.anyList())
        }
    }

    private fun `then, teams are requested from the local database`() {
        teamsDataSource.getTeams(leagueName){
            Mockito.verify(teamsPersistenceDataSource).getTeamsLocal(leagueName!!)
        }
    }

    private fun `then, local entities are mapped to domain entities`() {
        teamsDataSource.getTeams(leagueName){
            TeamsMapper.mapLocalEntitytoDomain(Mockito.anyList())
        }
    }
}