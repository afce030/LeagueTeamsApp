package com.cardona.data.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class TeamLocalEntity (

    @ColumnInfo(name = "strTeam")
    val strTeam: String? = null,

    @ColumnInfo(name = "strDescriptionEN")
    val strDescriptionEN: String? = null,

    @ColumnInfo(name = "intFormedYear")
    val intFormedYear: String? = null,

    @ColumnInfo(name = "strTeamBadge")
    val strTeamBadge: String? = null,

    @ColumnInfo(name = "strTeamJersey")
    val strTeamJersey: String? = null,

    @ColumnInfo(name = "strWebsite")
    var strWebsite: String? = null

)
