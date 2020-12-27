package com.example.myapplication.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.database.PeriodDatabase
import com.example.myapplication.data.models.Period
import com.example.myapplication.logic.repository.PeriodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeriodViewModel (application: Application) : AndroidViewModel (application) {
    private val repository: PeriodRepository

    val getAllPeriod: LiveData<List<Period>>

    init {
        val periodDao = PeriodDatabase.getDatabase(application).periodDao()
        repository = PeriodRepository(periodDao)

        getAllPeriod = repository.getAllPeriod
    }

    fun addPeriod (period: Period) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPeriod(period)
        }
    }
    fun updatePeriod (period: Period) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePeriod(period)
        }
    }
    fun deletePeriod (period: Period) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePeriod(period)
        }
    }

}