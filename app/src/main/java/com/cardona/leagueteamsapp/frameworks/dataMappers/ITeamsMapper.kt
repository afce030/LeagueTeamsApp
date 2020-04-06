package com.cardona.leagueteamsapp.frameworks.dataMappers

import com.cardona.leagueteamsapp.frameworks.retrofit.dto.TeamDTO
import com.cardona.domain.entities.Team
import com.cardona.leagueteamsapp.frameworks.room.entities.TeamLocalEntity

interface ITeamsMapper {
    fun mapDTOtoDomain(teams: List<TeamDTO>) : List<Team>
    fun mapDomaintoLocalEntities(teams: List<Team>) : List<TeamLocalEntity>
    fun mapLocalEntitytoDomain(teams: List<TeamLocalEntity>) : List<Team>
}
