package com.cardona.leagueteamsapp.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cardona.domain.useCases.GetLeagueTeams
import com.cardona.leagueteamsapp.presentation.adapters.TeamsAdapter
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.CommandInvoker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


class TeamsViewModelTest{

    private lateinit var commandInvoker: CommandInvoker
    private lateinit var leagueName: String

    private lateinit var getLeagueTeams: GetLeagueTeams
    private lateinit var teamsViewModel: TeamsViewModel
    private lateinit var teamsAdapter: TeamsAdapter

    //Probe architecture components synchronously
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val testDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    val testScope = TestCoroutineScope(testDispatcher)

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {

        Dispatchers.setMain(testDispatcher)

        commandInvoker = Mockito.mock(CommandInvoker::class.java)
        getLeagueTeams = Mockito.mock(GetLeagueTeams::class.java)
        teamsAdapter = Mockito.mock(TeamsAdapter::class.java)
        teamsViewModel = TeamsViewModel(
            getLeagueTeams = getLeagueTeams,
            commandInvoker = commandInvoker,
            teamsAdapter = teamsAdapter
        )

        teamsViewModel.scope = testScope
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `assert that teamsviewmodel is invoking use case`() {
        `given the league name`()
        `when teams are requested by the user`()
        `then, getTeams use case is invoked`()
    }

    @Test
    fun `assert that progress bar command is emitted`() {
        `given the league name`()
        `when teams are requested by the user`()
        `then, progress bar command is emitted`()
    }

    @Test
    fun `assert that populate recyclerview command is emitted`() {
        `given the league name`()
        `when teams are requested by the user`()
        `then, recyclerview populate command is emitted`()
    }

    @Test
    fun `assert that progress bar stopping is emitted`() {
        `given the league name`()
        `when teams are requested by the user`()
        `then, progress bar stopping is emitted`()
    }

    private fun `given the league name`() {
        leagueName = "Spain"
    }

    private fun `when teams are requested by the user`() {
        teamsViewModel.getForTeams(leagueName)
    }

    private fun `then, getTeams use case is invoked`() = runBlocking{
        Mockito.verify(getLeagueTeams).invoke(leagueName)
    }

    private fun `then, progress bar command is emitted`() {
        Mockito.verify(commandInvoker).setViewCommand(anyObject())
    }

    private fun `then, recyclerview populate command is emitted`() = runBlocking{
        Mockito.verify(commandInvoker).setViewCommand(anyObject())
    }

    private fun `then, progress bar stopping is emitted`() = runBlocking{
        Mockito.verify(commandInvoker).setViewCommand(anyObject())
    }

    private fun <T> anyObject(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T

}