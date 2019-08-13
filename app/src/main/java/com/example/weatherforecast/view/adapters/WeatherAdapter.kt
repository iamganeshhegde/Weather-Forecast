package com.example.weatherforecast.view.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.BR
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.ItemWeatherForecastBinding
import com.example.weatherforecast.model.dataclass.Forecastday

class WeatherAdapter(var context: Context, listOfForecast: ArrayList<Forecastday>?) :
    RecyclerView.Adapter<WeatherAdapter.MyViewHolder>() {
    var weatherForecastList: ArrayList<Forecastday>? = null

    init {
        weatherForecastList = listOfForecast
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var bind: ItemWeatherForecastBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weather_forecast, parent, false)
        return MyViewHolder(bind)
    }

    override fun getItemCount(): Int {

        if (weatherForecastList != null) {
            return weatherForecastList!!.size - 1
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var forecastData = weatherForecastList?.get(position + 1)
        if (forecastData != null) {
            holder.bind(forecastData)
        }
    }

    fun updateListInRecyclerView(listOfForecast: ArrayList<Forecastday>?) {
        weatherForecastList = listOfForecast
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: ItemWeatherForecastBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding: ItemWeatherForecastBinding = itemView

        fun bind(obj: Any) {
            binding.setVariable(BR.forecastdata, obj)
            binding.executePendingBindings()
        }
    }
}