package com.cardona.domain.repositories

import com.cardona.domain.entities.Team
import io.reactivex.Single

interface ITeamsRepository {
    suspend fun getTeamsFromAPi(leagueName: String): Single<List<Team>>
}