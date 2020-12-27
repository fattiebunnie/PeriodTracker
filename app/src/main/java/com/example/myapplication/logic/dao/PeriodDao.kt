package com.example.myapplication.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.data.models.Period


@Dao
interface PeriodDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPeriod(period: Period)

    @Update
    suspend fun updatePeriod(period: Period)

    @Delete
    suspend fun deletePeriod(period: Period)

    @Query
        ("SELECT * FROM period_table ORDER BY id DESC")
    fun getAllPeriod(): LiveData<List<Period>>

}