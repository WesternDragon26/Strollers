package com.example.strollers.strollers.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Destination implements Serializable {

    @SerializedName("geometry")
    private Geometry geometry;

    @SerializedName("icon")
    private String icon;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("place_id")
    private String placeid;

    @SerializedName("reference")
    private String reference;

    @SerializedName("scope")
    private String scope;

    @SerializedName("types")
    private List<String> types;

    @SerializedName("vicinity")
    private String vicinity;

    private Double distance = 0.0;

    public Geometry getGeometry() {
        return geometry;
    }

    public Double getLat(){
        return getGeometry().getPosition().getLat();
    }

    public Double getLng() {
        return getGeometry().getPosition().getLng();
    }

    public String getIcon() {
        return icon;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlaceID() {
        return placeid;
    }

    public String getReference() {
        return reference;
    }

    public String getScope() {
        return scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public Double getDistance() {return distance;}

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}


