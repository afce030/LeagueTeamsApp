package com.cardona.leagueteamsapp.frameworks.dataMappers

import com.cardona.leagueteamsapp.frameworks.retrofit.dto.TeamDTO
import com.cardona.domain.entities.Team
import com.cardona.leagueteamsapp.frameworks.room.entities.TeamLocalEntity
import javax.inject.Inject

class TeamsMapper @Inject constructor() : ITeamsMapper {

    override fun mapDTOtoDomain(teams: List<TeamDTO>) : List<Team>{

        val teamDomainEntities = mutableListOf<Team>()

        teams.forEach { team ->

            teamDomainEntities.add(
                    Team(
                        name = Team.Name(team.strTeam),
                        description = team.strDescriptionEN,
                        foundationYear = Team.Year(team.intFormedYear),
                        badge = Team.Badge(team.strTeamBadge, team.strTeamJersey.toString()),
                        events = listOf(),
                        link = team.strWebsite,
                        country = team.strCountry
                    )
            )

        }

        return teamDomainEntities

    }

    override fun mapDomaintoLocalEntities(teams: List<Team>) : List<TeamLocalEntity>{

        val teamLocalEntities = mutableListOf<TeamLocalEntity>()

        teams.forEach { team ->

            teamLocalEntities.add(
                    TeamLocalEntity(
                        strTeam = team.name.name!!,
                        strDescriptionEN = team.description,
                        intFormedYear = team.foundationYear.year,
                        strTeamBadge = team.badge.badge,
                        strTeamJersey = team.badge.jersey,
                        strWebsite = team.link,
                        strCountry = team.country
                    )
            )

        }

        return teamLocalEntities

    }

    override fun mapLocalEntitytoDomain(teams: List<TeamLocalEntity>) : List<Team> {

        val teamsDomain = mutableListOf<Team>()

        teams.forEach { team ->

            teamsDomain.add(
                    Team(
                        name = Team.Name(team.strTeam),
                        description = team.strDescriptionEN,
                        foundationYear = Team.Year(team.intFormedYear),
                        badge = Team.Badge(team.strTeamBadge, team.strTeamJersey),
                        events = listOf(),
                        link = team.strWebsite,
                        country = team.strCountry
                    )
            )

        }

        return teamsDomain

    }

}
