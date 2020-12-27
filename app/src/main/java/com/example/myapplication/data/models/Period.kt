package com.example.myapplication.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "period_table")
data class Period (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val period_title: String,
    val period_description: String,
    val period_start_time: String,
    val period_end_time: String,
    val imageId: Int
) : Parcelable