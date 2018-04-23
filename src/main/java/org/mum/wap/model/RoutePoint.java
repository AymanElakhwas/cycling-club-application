package org.mum.wap.model;

public class RoutePoint {
    private String lon;
    private String lat;
    private int order;
    private Event event;

    public RoutePoint(String lon, String lat, int order,Event event) {
        this.lon = lon;
        this.lat = lat;
        this.order = order;
        this.event=event;
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

    public Event getEvent() {
        return this.event;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
