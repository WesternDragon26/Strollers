package com.example.strollers.strollers.Models;

public class Route {
    private Geometry geometry;
    private String origin;
    private String destination;
    private Double distance;

    public Route(String origin, String destination, Double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Double getDistance() {
        return distance;
    }
}
