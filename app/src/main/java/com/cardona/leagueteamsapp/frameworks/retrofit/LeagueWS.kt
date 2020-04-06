package com.cardona.leagueteamsapp.frameworks.retrofit

import com.cardona.leagueteamsapp.frameworks.retrofit.dto.ResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LeagueWS {

    @GET("search_all_teams.php")
    fun requestForTeams(
        @Query("s") sport: String,
        @Query("c") country: String
    ): Call<ResponseDTO>

}