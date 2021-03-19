package com.github.xvar.data.repository

import com.github.xvar.domain.model.Measurement
import com.github.xvar.domain.model.Task
import com.github.xvar.domain.model.Technology
import io.reactivex.rxjava3.core.Single

interface RecordRepository {

    fun getFilteredRecords(task: Task, technology: Technology) : Single<List<Measurement>>

}