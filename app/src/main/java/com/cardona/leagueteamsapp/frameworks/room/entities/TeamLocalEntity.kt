package com.cardona.leagueteamsapp.frameworks.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams_entity")
data class TeamLocalEntity (

    @PrimaryKey
    @ColumnInfo(name = "strTeam")
    val strTeam: String,

    @ColumnInfo(name = "strDescriptionEN")
    val strDescriptionEN: String? = null,

    @ColumnInfo(name = "intFormedYear")
    val intFormedYear: String? = null,

    @ColumnInfo(name = "strTeamBadge")
    val strTeamBadge: String? = null,

    @ColumnInfo(name = "strTeamJersey")
    val strTeamJersey: String? = null,

    @ColumnInfo(name = "strWebsite")
    var strWebsite: String? = null,

    @ColumnInfo(name = "strCountry")
    val strCountry: String? = null

)
