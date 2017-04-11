package com.example.eka.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://newsky2.kma.go.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIRequest apiRequest = retrofit.create(APIRequest.class);
        apiRequest.getWeather().enqueue(new Callback<WeatherReturn>() {
            @Override
            public void onResponse(Call<WeatherReturn> call, Response<WeatherReturn> response) {
                switch (response.code()){
                    case 200:
                        Log.e("Asdf", response.body().getResponse().getBody().getItems().getItem().getWfSv());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<WeatherReturn> call, Throwable t) {

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
