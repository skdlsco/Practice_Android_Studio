package com.example.eka.weather;

import android.icu.text.SimpleDateFormat;
import android.os.Build;

import java.sql.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by eka on 2017. 4. 11..
 */


public interface APIRequest {


    @GET("/service/MiddleFrcstInfoService/getMiddleForecast?ServiceKey=5fgo5wTAbUVB1YcL0HsuPjnpQsvnWoBivnL5BOBZB5cIEs%2F%2FM4EFLQMeyT87ri2y%2FIqkxeKGBoCAAVjEfb12VA%3D%3D&stnId=109&pageNo=1&numOfRows=1&type=json")
    Call<WeatherTextReturn> getWeatherText(@Query("tmFc") String date);

    @GET("/service/MiddleFrcstInfoService/getMiddleTemperature?serviceKey=5fgo5wTAbUVB1YcL0HsuPjnpQsvnWoBivnL5BOBZB5cIEs%2F%2FM4EFLQMeyT87ri2y%2FIqkxeKGBoCAAVjEfb12VA%3D%3D&(%ED%95%84%EC%88%98)ServiceKey=5fgo5wTAbUVB1YcL0HsuPjnpQsvnWoBivnL5BOBZB5cIEs%252F%252FM4EFLQMeyT87ri2y%252FIqkxeKGBoCAAVjEfb12VA%253D%253D&regId=11B10101&pageNo=1&startPage=1&numOfRows=10&pageSize=10&type=json")
    Call<WeatherTemperature> getWeatherTemperature(@Query("tmFc") String date);

    @GET("/")
    Call<ResponseBody> getTemp();
}
