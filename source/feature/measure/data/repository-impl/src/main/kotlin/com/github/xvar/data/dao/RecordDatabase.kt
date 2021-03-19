package com.github.xvar.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Record::class], version = 1)
@TypeConverters(RecordConverters::class)
internal abstract class RecordDatabase: RoomDatabase() {

    internal abstract fun recordDao() : RecordDao

}