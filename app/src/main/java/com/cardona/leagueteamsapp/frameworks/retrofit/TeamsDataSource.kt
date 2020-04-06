package com.cardona.leagueteamsapp.frameworks.retrofit

import android.util.Log
import com.cardona.data.remoteSources.ITeamsDataSource
import com.cardona.leagueteamsapp.frameworks.retrofit.dto.ResponseDTO
import com.cardona.domain.entities.Team
import com.cardona.leagueteamsapp.frameworks.dataMappers.ITeamsMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TeamsDataSource @Inject constructor(
    private val teamsMapper: ITeamsMapper,
    private val leagueWebServiceImpl: LeagueWS
): ITeamsDataSource {

    override fun getTeams(leagueName: String, callback: (List<Team>) -> Unit) {

        val call = leagueWebServiceImpl.requestForTeams("Soccer", leagueName)

        call.enqueue(object : Callback<ResponseDTO> {

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {}

            override fun onResponse(
                call: Call<ResponseDTO>,
                response: Response<ResponseDTO>
            ) {

                //Log.d("dataRoute", "requested retrofit")

                when (response.code()) {
                    200 -> {
                        response.body()?.let { data ->
                            Log.d("dataRoute", "retrofit "+data.toString())

                            //Necesario usar paginación
                            callback(teamsMapper.mapDTOtoDomain(data.teams.subList(0,30)))
                            //Log.d("dataRoute", teamsMapper.mapDTOtoDomain(data.teams).size.toString())
                        }
                    }
                }

            }

        })
    }

}