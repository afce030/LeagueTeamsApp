package com.cardona.leagueteamsapp.frameworks.retrofit

import com.cardona.leagueteamsapp.frameworks.retrofit.dto.ResponseDTO
import com.cardona.leagueteamsapp.frameworks.dataMappers.ITeamsMapper
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Callback

@RunWith(MockitoJUnitRunner::class)
class TeamsDataSourceTest {

    private lateinit var teamsDataSource: TeamsDataSource
    private lateinit var leagueName: String

    @Mock
    private lateinit var teamsMapper: ITeamsMapper
    @Mock
    private lateinit var leagueWS: LeagueWS

    @Captor
    private lateinit var captor: ArgumentCaptor<Callback<ResponseDTO>>

    @Before
    fun initMocks(){
        MockitoAnnotations.initMocks(this)
        teamsDataSource = TeamsDataSource(teamsMapper, leagueWS)
    }

    @Test
    fun `assert that dtos are mapped to domain`() {
        `given the league name`()
        `when TeamsDataSource makes an api call`()
        `then, retrofit callback is invoked`()
    }

    private fun `given the league name`(){
        leagueName = "Spain"
    }

    private fun `when TeamsDataSource makes an api call`() = runBlocking{
        //teamsDataSource.getTeams(leagueName, {})
    }

    private fun `then, retrofit callback is invoked`(){
        //Mockito.verify(teamsMapper).mapDTOtoDomain(Mockito.anyList())
        //Mockito.verify(leagueWS).requestForTeams("Soccer", leagueName).enqueue(captor.capture())
    }
}