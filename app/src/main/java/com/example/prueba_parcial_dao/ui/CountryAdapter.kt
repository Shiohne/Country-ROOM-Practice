package com.example.prueba_parcial_dao.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba_parcial_dao.R
import com.example.prueba_parcial_dao.data.entities.Country

class CountryAdapter (private val context: Context, private var countries:MutableList<Country>):
        RecyclerView.Adapter<CountryAdapter.CountryItem>(){

    inner class CountryItem(itemView: View):RecyclerView.ViewHolder(itemView){

        private lateinit var tvFullName:TextView
        private lateinit var tvShortName:TextView
        private lateinit var tvCopas:TextView

        fun bindTo(country: Country){
            tvFullName = itemView.findViewById(R.id.tvFullName)
            tvFullName.text = country.fullName
            tvShortName = itemView.findViewById(R.id.tvShortName)
            tvShortName.text = country.shortName
            tvCopas = itemView.findViewById(R.id.tvCopas)
            tvCopas.text = country.copas.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.CountryItem {
        val view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false)
        return CountryItem(view)
    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryItem, position: Int) {
        holder.bindTo(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    fun setCountries(countries: MutableList<Country>) {
        this.countries = countries
        notifyDataSetChanged()
    }


}