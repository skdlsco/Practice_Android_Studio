package com.example.eka.weather;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.sql.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView weathertext= (TextView) findViewById(R.id.WeatherText);
        final TextView weathertem= (TextView) findViewById(R.id.WeatherTemp);
        final TextView liverTemp = (TextView) findViewById(R.id.LiverTemp);

        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMdd", java.util.Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        String strDate = dateFormat.format(date)+"0600";
        Log.e("asdf",strDate);
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://newsky2.kma.go.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final APIRequest apiRequest = retrofit.create(APIRequest.class);

        final Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://hangang.dkserver.wo.tc")
                .build();

        final APIRequest apiRequest1 = retrofit1.create(APIRequest.class);
        apiRequest1.getTemp().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                JSONObject jsonObject;
                switch (response.code()) {
                    case 200:
                        try {
                            jsonObject = new JSONObject(response.body().string());
                            liverTemp.setText("지금 한강 온도"+jsonObject.getString("temp")+"도");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default: break;
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        apiRequest.getWeatherText(strDate).enqueue(new Callback<WeatherTextReturn>() {
            @Override
            public void onResponse(Call<WeatherTextReturn> call, Response<WeatherTextReturn> response) {
                Log.e("asdf",apiRequest.toString());

                switch (response.code()){
                    case 200:
                        weathertext.setText(response.body().getResponse().getBody().getItems().getItem().getWfSv());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<WeatherTextReturn> call, Throwable t) {
                Log.e("asdf", String.valueOf(retrofit.baseUrl()));

            }
        });
        apiRequest.getWeatherTemperature(strDate).enqueue(new Callback<WeatherTemperature>() {
            @Override
            public void onResponse(Call<WeatherTemperature> call, Response<WeatherTemperature> response) {
                switch (response.code()){
                    case 200:
                        Log.e("asd1f",response.body().toString());
                        weathertem.setText(response.body().getResponse().getBody().getItems().getItem().getTaMax3()+" ~ "+response.body().getResponse().getBody().getItems().getItem().getTaMin3());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<WeatherTemperature> call, Throwable t) {

            }
        });
//        apiRequest.getWeather().enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                switch (response.code()) {
//                    case 200:
//                        JSONObject json = null;
//                        try {
//                            json = new JSONObject(response.body().string());
//                            Log.e("asdf",
//                                    json.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONObject("item").getString("wfSv"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        } finally {
//                        }
//                        break;
//                    default:
//                        Toast.makeText(MainActivity.this, response.code() + "", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
