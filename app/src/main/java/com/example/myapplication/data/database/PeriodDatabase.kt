package com.example.myapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.models.Period
import com.example.myapplication.logic.dao.PeriodDao
import java.security.AccessControlContext

@Database(entities = [Period::class], version = 1, exportSchema = false)
abstract class PeriodDatabase : RoomDatabase() {

    abstract fun  periodDao() : PeriodDao

    companion object {
        @Volatile
        private var INSTANCE: PeriodDatabase? = null

        fun getDatabase(context: Context): PeriodDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PeriodDatabase::class.java,
                    "period_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }


}