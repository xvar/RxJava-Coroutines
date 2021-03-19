package com.github.xvar.domain.model

data class Measurement(
    val technology: Technology,
    val executor: Executor,
    val task: Task,
    val timeNs: Long
)