package com.github.xvar.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.xvar.domain.model.Task
import com.github.xvar.domain.model.Executor
import com.github.xvar.domain.model.Technology

@Entity(tableName = Record.TABLE_NAME)
class Record(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID) val id: Long? = null,
    @ColumnInfo(name = TASK) val task: Task,
    @ColumnInfo(name = EXECUTOR) val executor: Executor,
    @ColumnInfo(name = TECH) val technology: Technology,
    @ColumnInfo(name = TIME_SPENT) val timeNs: Long
) {

    companion object Field {
        const val ID = "id"
        const val TABLE_NAME = "test_records"
        const val TASK = "task"
        const val EXECUTOR = "executor"
        const val TECH = "technology"
        const val TIME_SPENT = "time_spent_ns"
    }

    override fun toString(): String {
        return "Record[id=$id, task = $task, executor = $executor, technology = $technology, " +
                "timeNs = $timeNs]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Record

        if (task != other.task) return false
        if (executor != other.executor) return false
        if (technology != other.technology) return false
        if (timeNs != other.timeNs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = task.hashCode()
        result = 31 * result + executor.hashCode()
        result = 31 * result + technology.hashCode()
        result = 31 * result + timeNs.hashCode()
        return result
    }

}