package org.mum.wap.model;

public class RoutePoint {
    private String lon;
    private String lat;
    private int order;

    public RoutePoint(String lon, String lat, int order) {
        this.lon = lon;
        this.lat = lat;
        this.order = order;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
