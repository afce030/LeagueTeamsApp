package com.cardona.leagueteamsapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardona.domain.useCases.GetLeagueTeams
import com.cardona.leagueteamsapp.R
import com.cardona.leagueteamsapp.presentation.adapters.TeamsAdapter
import com.cardona.leagueteamsapp.presentation.viewCommands.*
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.CommandInvoker
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class TeamsViewModel @Inject constructor(
    private val getLeagueTeams: GetLeagueTeams,
    private val commandInvoker: CommandInvoker,
    private val teamsAdapter: TeamsAdapter
): ViewModel() {

    var scope = viewModelScope
    val commandInvokerEmitter = CommandsLiveData<CommandInvoker>()

    fun getForTeams(leagueName: String) {

        commandInvoker.setViewCommand(
            ProgressBarStart(R.id.progress_bar, R.id.darkView)
        )

        commandInvokerEmitter.postValue(commandInvoker)

        scope.launch(IO) {

            getLeagueTeams.invoke(leagueName).subscribe{ data ->

                Log.d("dataRoute", "equipos: "+data.toString())

                data?.let{

                    commandInvoker.setViewCommand(
                            PopulateRecyclerView(
                                R.id.rvTeamsList,
                                teamsAdapter,
                                    data
                            )
                    )
                    commandInvokerEmitter.postValue(commandInvoker)

                    commandInvoker.setViewCommand(
                        ProgressBarStop(R.id.progress_bar, R.id.darkView)
                    )
                    commandInvokerEmitter.postValue(commandInvoker)

                }

            }

        }
    }


}