package com.github.xvar.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.github.xvar.domain.model.Executor
import com.github.xvar.domain.model.Task
import com.github.xvar.domain.model.Technology
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecordDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: RecordDatabase

    @Before
    fun initDb() {
        // using an in-memory database because the information stored here disappears after test
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            RecordDatabase::class.java)
            // allowing main thread queries, just for testing
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDb() {
        database.clearAllTables()
        database.close()
    }

    @Test
    fun insertAndGetItem() {
        val rxIo = Record(
            task = Task.NETWORK,
            executor = Executor.RX_IO,
            technology = Technology.RXJAVA2,
            timeNs = 100_000_000
        )
        val rxIo2 = Record(
            task = Task.NETWORK,
            executor = Executor.RX_IO,
            technology = Technology.RXJAVA2,
            timeNs = 100_000_002
        )
        val cor = Record(
            task = Task.NETWORK,
            executor = Executor.DISPATCHER_IO,
            technology = Technology.COROUTINES,
            timeNs = 200_000_000
        )

        database.recordDao().insert(rxIo).blockingAwait()
        database.recordDao().insert(rxIo2).blockingAwait()
        database.recordDao().insert(cor).blockingAwait()

        database.recordDao()
            .getOrderedRecords(Task.NETWORK)
            .test()
            .assertValue(listOf(rxIo, rxIo2, cor))

    }
}