package com.github.xvar.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.xvar.data.model.Case
import com.github.xvar.data.model.Executor
import com.github.xvar.data.model.Technology

@Entity(tableName = TestRecord.TABLE_NAME)
internal class TestRecord(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = CASE) val case: Case,
    @ColumnInfo(name = EXECUTOR) val executor: Executor,
    @ColumnInfo(name = TECH) val technology: Technology,
    @ColumnInfo(name = TIME_SPENT) val timeNs: Long
) {

    companion object Field {
        const val TABLE_NAME = "test_records"
        const val CASE = "case"
        const val EXECUTOR = "executor"
        const val TECH = "technology"
        const val TIME_SPENT = "time_spent_ns"
    }

}