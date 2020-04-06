package com.cardona.leagueteamsapp.frameworks.room.methods

import androidx.room.*
import com.cardona.leagueteamsapp.frameworks.room.entities.TeamLocalEntity
import io.reactivex.Single

@Dao
interface LeaguesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeams(vararg teamLocalEntity: TeamLocalEntity)

    @Delete
    fun deleteTeams(vararg teamLocalEntity: TeamLocalEntity)

    @Query("SELECT * FROM teams_entity WHERE strCountry LIKE :leagueName")
    fun getTeamsFromLocal(leagueName: String): Single<List<TeamLocalEntity>>

}