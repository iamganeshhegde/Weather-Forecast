package com.example.weatherforecast.view.adapters


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.BR
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.ItemWeatherForecastBinding
import com.example.weatherforecast.model.dataclass.Forecastday

class WeatherAdapter(var context: Context,listOfForecast: ArrayList<Forecastday>?) : RecyclerView.Adapter<WeatherAdapter.MyViewHolder>() {

    var weatherForecastList: ArrayList<Forecastday>? = null
    lateinit var animation :Animation

    init {
        weatherForecastList = listOfForecast
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


         var bind:ItemWeatherForecastBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_weather_forecast,parent,false)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_forecast,parent,false)
        Log.i("Oncreateviewholder"," called")
        return MyViewHolder(bind)

    }

    override fun getItemCount(): Int {

        if(weatherForecastList != null){
            return weatherForecastList!!.size-1
        }
        return 0

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        var forecastData = weatherForecastList?.get(position+1)


        if (forecastData != null) {
            holder.bind(forecastData)
        }
//        holder.binding.forecastdata = forecastData

        /* var dayCondition = weatherForecastList?.get(position)?.getDay()
         if (dayCondition != null) {
             holder.tvWeatherCondition.text = dayCondition.getCondition()?.getText() ?: "Normal"
         }
         holder.tvDegreeCelcius.text = dayCondition?.getAvgtempC().toString()

         if (dayCondition != null) {
             if (dayCondition.getCondition() != null) {

                 Log.i(TAG, dayCondition.getCondition()!!.getIcon())
                 Picasso.get().load("http:"+dayCondition.getCondition()!!.getIcon()).into(holder.ivWeather)
     //            Glide.with(context).load(condition.getIcon() ).dontAnimate().into(holder.ivWeather)
             }
         }
 */




    }

    fun updateListInRecyclerView(listOfForecast: ArrayList<Forecastday>?) {

        weatherForecastList = listOfForecast
        notifyDataSetChanged()

    }

    class MyViewHolder(itemView:ItemWeatherForecastBinding):RecyclerView.ViewHolder(itemView.root) {
         var binding: ItemWeatherForecastBinding
           init {
               binding  =itemView

           }
       fun bind(obj:Any){

           binding.setVariable(BR.forecastdata,obj)
           binding.executePendingBindings()
       }

        var ivWeather = itemView.ivWeather
        var tvDay = itemView.tvDay
        var tvWeatherCondition = itemView.tvWeatherCondition
        var tvDegreeCelcius = itemView.tvDegreeCelcius

    }
}