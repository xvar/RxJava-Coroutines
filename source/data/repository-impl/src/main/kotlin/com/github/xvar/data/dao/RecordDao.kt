package com.github.xvar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.xvar.domain.model.Task
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
internal interface RecordDao {

    @Query(
        "Select * from ${Record.TABLE_NAME} where ${Record.TASK} = :task order by ${Record.TECH}, ${Record.EXECUTOR}"
    )
    fun getOrderedRecords(task: Task): Flowable<List<Record>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(record: Record) : Completable

}