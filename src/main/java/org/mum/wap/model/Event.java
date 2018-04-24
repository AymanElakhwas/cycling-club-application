package org.mum.wap.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayman Elakhwas
 */
public class Event {
    private long id;
    private String title;
    private String description;
    private LocalDate startDateTime;
    private int status;
    private String currentLocation;
    private User owner;
    private int created_by;
    private List<User> participants = new ArrayList<>();
    private List<RoutePoint> route = new ArrayList<>();

    public Event() {
    }

    public Event(long id, String title, String description, LocalDate startDateTime, int status, String currentLocation, List<RoutePoint> route) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.status = status;
        this.route = route;
        this.currentLocation = currentLocation;

    }
    public Event(long id, String title, String description, LocalDate startDateTime, int status,String currentLocation,int created_by) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.status = status;
        this.route = route;
        this.currentLocation = currentLocation;
        this.created_by=created_by;
    }
    public Event(long id, String title, String description, LocalDate startDateTime, int status, User owner, String currentLocation, List<User> participants, List<RoutePoint> route) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.status = status;
        this.owner = owner;
        this.participants = participants;
        this.route = route;
    }

    public long getId() {
        return id;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    ;

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDate startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getStatus() {
        return status;
    }
    public int getCreated_by() {
        return this.created_by;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public List<RoutePoint> getRoute() {
        return route;
    }
    public void getRoute(List<RoutePoint> lstPoints) {
        this.route=lstPoints;
    }

    public void setRoute(List<RoutePoint> route) {
        this.route = route;
    }
}
