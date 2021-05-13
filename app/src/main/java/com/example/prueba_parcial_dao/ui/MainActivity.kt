package com.example.prueba_parcial_dao.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueba_parcial_dao.R
import com.example.prueba_parcial_dao.data.entities.Country
import com.example.prueba_parcial_dao.databinding.ActivityMainBinding
import com.example.prueba_parcial_dao.local.AppDatabase
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countryAdapter:CountryAdapter
    private var countries: MutableList<Country> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initListeners()

    }

    private fun loadCountries() {
        countries = AppDatabase.getInstance(this).countryDao().getAll()
    }

    private fun initListeners() {
       binding.btAdd.setOnClickListener{

           //SE INSERTA EL PAÍS
           var shortName = binding.etCountryShortName.text.toString().trim()
           var fullName = binding.etCountryFullName.text.toString().trim()
           var copas = Integer.parseInt(binding.etCountryCopas.text.toString().trim())
           var country = Country (0, fullName, shortName, copas)

           AppDatabase.getInstance(this,).countryDao().insert(country)
           Log.d("Country Insertado:",Gson().toJson(country))

           //Funcion para mostrar paises
           showCountries()

       }
    }

    private fun showCountries() {
        //Funcion para jalar países de la room
        loadCountries()
        //Se inicializa el RV
        countryAdapter = CountryAdapter(this, countries)
        binding.rvCountries.adapter = countryAdapter
        binding.rvCountries.layoutManager = LinearLayoutManager(this)
        //Se añaden los countries al RV
        countryAdapter.setCountries(countries)

        Log.d("Country del ROOM: ",Gson().toJson(countries))
    }

}