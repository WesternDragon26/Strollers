package com.example.strollers.strollers.Models;

import com.example.strollers.strollers.Helpers.RouteHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Destinations {

    @SerializedName("results")
    private List<Destination> destsList;

    public Destinations() {
        destsList = new ArrayList<>();
    }

    public List getDestsList() {
        return destsList;
    }

    public void initializeDistances(Double currLat, Double currLng) {

        for (int i = 0; i < destsList.size(); i++) {
            Destination destination = destsList.get(i);
            /* Calculate linear distance between origin and destination */
            destination.setDistance(RouteHelper.distance(currLat, currLng, destination.getLat(), destination.getLng()));
        }
    }

    public static Destinations parseJson(String response) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response, Destinations.class);
    }
}
