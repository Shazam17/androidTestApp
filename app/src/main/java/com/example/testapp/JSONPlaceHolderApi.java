package com.example.testapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("https://test.kode-t.ru/recipes")
    public Call<ListModel>getRecipes();

    @GET("/recipes/fc988768-c1e9-11e6-a4a6-cec0c932ce01")
    public Call<recipe>getRecipe();

    @GET("/recipes/fc988768-c1e9-11e6-a4a6-cec0c932ce01")
    public Call<WrapperRecipe>getRecipeWrapper();



}
