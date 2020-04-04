package com.cardona.data.mappers

import com.cardona.data.persistence.TeamLocalEntity
import com.cardona.data.remoteSources.dto.TeamDTO
import com.cardona.domain.entities.Team

object TeamsMapper {

    fun mapDTOtoLocalEntity(teams: List<TeamDTO>) : List<TeamLocalEntity>{

        val teamLocalEntities = mutableListOf<TeamLocalEntity>()

        teams.forEach { team ->

            teamLocalEntities.add(
                    TeamLocalEntity(
                        strTeam = team.strTeam,
                        strDescriptionEN = team.strDescriptionEN,
                        intFormedYear = team.intFormedYear,
                        strTeamBadge = team.strTeamBadge,
                        strTeamJersey = team.strTeamJersey.toString(),
                        strWebsite = team.strWebsite
                    )
            )

        }

        return teamLocalEntities

    }

    fun mapLocalEntitytoDomain(teams: List<TeamLocalEntity>) : List<Team> {

        val teamsDomain = mutableListOf<Team>()

        teams.forEach { team ->

            teamsDomain.add(
                    Team(
                        name = Team.Name(team.strTeam),
                        description = team.strDescriptionEN,
                        foundationYear = Team.Year(team.intFormedYear),
                        badge = Team.Badge(team.strTeamBadge, team.strTeamJersey),
                        events = listOf(),
                        link = team.strWebsite
                    )
            )

        }

        return teamsDomain

    }

}
