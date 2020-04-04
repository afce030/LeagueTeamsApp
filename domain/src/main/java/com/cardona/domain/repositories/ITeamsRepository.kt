package com.cardona.domain.repositories

interface ITeamsRepository {
    fun getTeamsFromAPi(leagueName: String)
}