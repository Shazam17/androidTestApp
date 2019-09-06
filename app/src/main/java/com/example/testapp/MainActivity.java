package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    FragmentList fragmentList;

    ArrayList<recipe> recipes;
    String url = "https://test.kode-t.ru/";


    private void parseSite(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceHolderApi service = retrofit.create(JSONPlaceHolderApi.class);

        Call<recipe> call = service.getRecipe();

        call.enqueue(new Callback<recipe>() {
            @Override
            public void onResponse(Call<recipe> call, Response<recipe> response) {
                if(response.isSuccessful()){
                    Toast tst1 = Toast.makeText(getApplicationContext(),response.body().getName(),Toast.LENGTH_SHORT);
                    tst1.show();
                }else{
                    switch (response.code()){
                        case 404:
                            Toast tst1 = Toast.makeText(getApplicationContext(),"page didnt find",Toast.LENGTH_SHORT);
                            tst1.show();
                        case 500:
                            Toast tst2 = Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_SHORT);
                            tst2.show();
                    }
                }
            }

            @Override
            public void onFailure(Call<recipe> call, Throwable t) {

            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentList = new FragmentList();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.container,fragmentList);

        transaction.commit();

        parseSite();

    }
}
