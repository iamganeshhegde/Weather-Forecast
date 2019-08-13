package com.example.weatherforecast.view.adapters;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.example.weatherforecast.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomBinding {

    @BindingAdapter("setday")
    public static void setDayOfWeek(TextView tv,String date){
        Log.i("date ",""+date);
   if (date==null){
       tv.setText(""+date+"");
       return;
   }

        String input_date=date;
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        Date dt1= null;
        try {
            dt1 = format1.parse(input_date);
            DateFormat format2=new SimpleDateFormat("EEEE");
            String finalDay=format2.format(dt1);
            tv.setText(finalDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    @BindingAdapter("setImage")
    public static void setImageRes(ImageView iv,String url){

        Picasso.get().load("https:"+url).error(R.drawable.ic_error_black_24dp).into(iv);

        Log.i("Image Url","https:"+url);
    }

    @BindingAdapter("setDegreeCelcius")
    public static void setDegreeCelcius(TextView tv,Double avgCelcius){

        if(avgCelcius == null){
            tv.setVisibility(View.GONE);
        }else {
            tv.setVisibility(View.VISIBLE);
            tv.setText(String.format("%s ℃", Double.toString(avgCelcius)));
        }
    }

}
