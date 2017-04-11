package com.example.eka.weather;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eka on 2017. 4. 11..
 */

public interface APIRequest {

    @GET("/service/MiddleFrcstInfoService/getMiddleForecast?ServiceKey=ZkFl7SPonLsb92Yuh2GR88cNMnOcwGgH89v7nlmPP1TunFljpyZr41KIUaeWsYyrvoH3gyBk7pav704NpBwpZA%3D%3D&stnId=133&tmFc=201704110600&pageNo=1&numOfRows=1&type=json")
    Call<WeatherReturn> getWeather();

}
