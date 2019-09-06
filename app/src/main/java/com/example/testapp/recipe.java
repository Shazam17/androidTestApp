package com.example.testapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.UUID;

public class recipe {

    @SerializedName("uuid")
    @Expose
    private UUID uuid;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("images")
    @Expose
    private ArrayList<String> images;

    @SerializedName("lastUpdated")
    @Expose
    private int lastUpdated;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("instructions")
    @Expose
    private String instructions;

    @SerializedName("difficulty")
    @Expose
    private int difficulty;

    @SerializedName("similar")
    @Expose
    private ArrayList<recipe> similar;

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

}
