package com.example.prueba_parcial_dao.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    var fullName: String,

    @ColumnInfo
    var shortName: String,

    @ColumnInfo
    var copas: Int

    )