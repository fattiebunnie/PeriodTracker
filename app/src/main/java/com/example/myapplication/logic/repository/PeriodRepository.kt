package com.example.myapplication.logic.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.models.Period
import com.example.myapplication.logic.dao.PeriodDao

class PeriodRepository (private val periodDao: PeriodDao) {
    val getAllPeriod : LiveData<List<Period>> = periodDao.getAllPeriod()


    suspend fun addPeriod (period: Period) {
        periodDao.addPeriod(period)
    }

    suspend fun updatePeriod(period: Period) {
        periodDao.updatePeriod(period)
    }

    suspend fun deletePeriod(period: Period) {
        periodDao.deletePeriod(period)
    }


}