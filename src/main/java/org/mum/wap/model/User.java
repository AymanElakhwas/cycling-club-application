package org.mum.wap.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;
    private String username;
    private String password;
    private String imgUrl;
    private List<Event> enrolledEvents = new ArrayList<>();
    private List<Event> createdEvents = new ArrayList<>();

    public User() {
    }

    public User(long id, String name, String username, String password, String imgUrl) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.imgUrl = imgUrl;
    }

    public User(long id, String name, String username, String password, String imgUrl, List<Event> enrolledEvents, List<Event> createdEvents) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.imgUrl = imgUrl;
        this.enrolledEvents = enrolledEvents;
        this.createdEvents = createdEvents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Event> getEnrolledEvents() {
        return enrolledEvents;
    }

    public void setEnrolledEvents(List<Event> enrolledEvents) {
        this.enrolledEvents = enrolledEvents;
    }

    public List<Event> getCreatedEvents() {
        return createdEvents;
    }

    public void setCreatedEvents(List<Event> createdEvents) {
        this.createdEvents = createdEvents;
    }
}
