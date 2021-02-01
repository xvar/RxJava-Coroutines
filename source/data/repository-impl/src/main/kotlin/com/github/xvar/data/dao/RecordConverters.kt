package com.github.xvar.data.dao

import androidx.room.TypeConverter
import com.github.xvar.data.model.Case
import com.github.xvar.data.model.Executor
import com.github.xvar.data.model.Technology

internal class RecordConverters {

    private object CaseTag {
        const val file = "file_read"
        const val network = "network"
    }

    @TypeConverter
    fun fromCase(case: Case?) : String? {
        return when(case) {
            null -> null
            Case.FILE_READ -> CaseTag.file
            Case.NETWORK -> CaseTag.network
            else -> CaseTag.file
        }
    }

    @TypeConverter
    fun toCase(value: String?) : Case? {
        return when(value) {
            null -> null
            CaseTag.file -> Case.FILE_READ
            CaseTag.network -> Case.NETWORK
            else -> Case.FILE_READ
        }
    }

    private object ExecutorTag {
        const val rxIo = "rx.io"
        const val rxComputation = "rx.computation"
        const val rxCustom = "rx.custom"
        const val dMain = "dispatchers.main"
        const val dIo = "dispatchers.io"
        const val dDefault = "dispatchers.default"
    }

    @TypeConverter
    fun fromExecutor(exec: Executor?) : String? {
        return when(exec) {
            null -> null
            Executor.RX_IO -> ExecutorTag.rxIo
            Executor.RX_COMPUTATION -> ExecutorTag.rxComputation
            Executor.RX_CUSTOM -> ExecutorTag.rxCustom
            Executor.DISPATCHER_MAIN -> ExecutorTag.dMain
            Executor.DISPATCHER_IO -> ExecutorTag.dIo
            Executor.DISPATCHER_DEFAULT -> ExecutorTag.dDefault
            else -> ExecutorTag.rxIo
        }
    }

    @TypeConverter
    fun toExecutor(value: String?) : Executor? {
        return when(value) {
            null -> null
            ExecutorTag.rxIo -> Executor.RX_IO
            ExecutorTag.rxComputation -> Executor.RX_COMPUTATION
            ExecutorTag.rxCustom -> Executor.RX_CUSTOM
            ExecutorTag.dMain -> Executor.DISPATCHER_MAIN
            ExecutorTag.dIo -> Executor.DISPATCHER_IO
            ExecutorTag.dDefault -> Executor.DISPATCHER_DEFAULT
            else -> Executor.RX_IO
        }
    }

    private object TechTag {
        const val rxJava2 = "RxJava2"
        const val rxJava3 = "RxJava3"
        const val flow = "Flow"
        const val coroutines = "coroutines"
    }
    @TypeConverter
    fun fromTech(tech: Technology?) : String? {
        return when(tech) {
            null -> null
            Technology.RXJAVA2 -> TechTag.rxJava2
            Technology.RXJAVA3 -> TechTag.rxJava3
            Technology.FLOW -> TechTag.flow
            Technology.COROUTINES -> TechTag.coroutines
        }
    }

    @TypeConverter
    fun toTech(value: String?) : Technology? {
        return when(value) {
            null -> null
            TechTag.rxJava2 -> Technology.RXJAVA2
            TechTag.rxJava3 -> Technology.RXJAVA3
            TechTag.flow -> Technology.FLOW
            TechTag.coroutines -> Technology.COROUTINES
            else -> Technology.RXJAVA2
        }
    }

}