package com.example.order.datasource.Room.DatabaseResult

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ResultEntity::class],version=1,exportSchema=false)
abstract class ResultDatabase :RoomDatabase() {
    abstract fun ResultDatabaseDAO(): ResultDAO

}
