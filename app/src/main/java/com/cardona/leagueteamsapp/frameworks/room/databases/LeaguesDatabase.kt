package com.cardona.leagueteamsapp.frameworks.room.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cardona.leagueteamsapp.frameworks.room.entities.TeamLocalEntity
import com.cardona.leagueteamsapp.frameworks.room.methods.LeaguesDAO

@Database(
    entities = [TeamLocalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LeaguesDatabase: RoomDatabase() {
    abstract fun leaguesDAO(): LeaguesDAO
}