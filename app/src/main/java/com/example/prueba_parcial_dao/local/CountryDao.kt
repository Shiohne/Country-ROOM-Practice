package com.example.prueba_parcial_dao.local

import androidx.room.*
import com.example.prueba_parcial_dao.data.entities.Country

@Dao
interface CountryDao {

    @Query("select * from country")
    fun getAll(): MutableList<Country>

    @Query("select * from country where fullName = :name")
    fun findByName(name: String): Country

    @Delete
    fun delete(country: Country)

    @Insert
    fun insert(vararg country: Country)

    @Update
    fun update(vararg country: Country)
}