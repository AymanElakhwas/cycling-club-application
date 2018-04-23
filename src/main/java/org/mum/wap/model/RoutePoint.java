package org.mum.wap.model;

public class RoutePoint {
    private String lon;
    private String lat;
    private int order;
    private int event_id;

    public RoutePoint(String lon, String lat, int order,int event_id) {
        this.lon = lon;
        this.lat = lat;
        this.order = order;
        this.event_id=event_id;
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

    public int getEvent_id() {
        return this.event_id;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
