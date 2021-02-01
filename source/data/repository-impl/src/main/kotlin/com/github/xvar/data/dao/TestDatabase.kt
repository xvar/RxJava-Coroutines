package com.github.xvar.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TestRecord::class], version = 1)
internal abstract class TestDatabase: RoomDatabase() {

    internal abstract fun testRecordDao() : TestRecordDao

}