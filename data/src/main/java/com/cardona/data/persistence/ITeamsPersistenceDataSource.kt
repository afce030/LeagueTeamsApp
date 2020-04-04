package com.cardona.data.persistence

interface ITeamsPersistenceDataSource {
    fun saveTeamsLocally(teams: List<TeamLocalEntity>)
    fun getTeamsLocal(leagueName: String): List<TeamLocalEntity>
}
