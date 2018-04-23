package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;
import org.mum.wap.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ayman Elakhwas
 * <p>
 * This class is used to serialize models to json objects
 */
public class JsonSerializer {
    public static JSONObject serialize(User user) {
        JSONObject obj = serializeWithoutDependency(user);

        JSONArray enrolledEventsList = new JSONArray();
        user.getEnrolledEvents().forEach(e -> enrolledEventsList.add(serializeWithoutDependency(e)));
        obj.put("enrolledEvents", enrolledEventsList);

        JSONArray createdEventsList = new JSONArray();
        user.getCreatedEvents().forEach(e -> createdEventsList.add(serializeWithoutDependency(e)));
        obj.put("createdEvents", createdEventsList);

        return obj;
    }

    public static JSONObject serialize(RoutePoint point) {
        JSONObject obj = new JSONObject();
        obj.put("lon", point.getLon());
        obj.put("lat", point.getLat());
        obj.put("order", point.getOrder());
        return obj;
    }

    public static JSONObject serialize(Event event) {
        JSONObject obj = serializeWithoutDependency(event);

        obj.put("owner", serializeWithoutDependency(event.getOwner()));

        JSONArray participants = new JSONArray();
        event.getParticipants().forEach(u -> participants.add(serializeWithoutDependency(u)));
        obj.put("participants", participants);

        return obj;
    }

    public static JSONArray serializeEvents(List<Event> events) {
        JSONArray arr = new JSONArray();
        events.forEach(e -> arr.add(serialize(e)));
        return arr;
    }

    public static JSONArray serializeUsers(List<User> users) {
        JSONArray arr = new JSONArray();
        users.forEach(u -> arr.add(serialize(u)));
        return arr;
    }

    public static JSONObject serializeWithoutDependency(User user) {
        JSONObject obj = new JSONObject();
        obj.put("id", user.getId());
        obj.put("name", user.getName());
        obj.put("username", user.getUsername());
        obj.put("password", user.getPassword());
        obj.put("imgUrl", user.getImgUrl());
        return obj;
    }

    public static JSONObject serializeWithoutDependency(Event event) {
        JSONObject obj = new JSONObject();
        obj.put("id", event.getId());
        obj.put("title", event.getTitle());
        obj.put("description", event.getDescription());
        obj.put("startDateTime", String.valueOf(event.getStartDateTime()));
        obj.put("status", event.getStatus());

        JSONArray route = new JSONArray();
        event.getRoute().forEach(p -> route.add(serialize(p)));
        obj.put("route", route);
        return obj;
    }


    public static JSONArray getMockEventsJson() {
        User user = new User(2, "ahmed", "myUserName", "pass", "images/testimg.jpg");
        List<RoutePoint> route = createTestRoute();
        Event event = new Event(1, "title", "description", LocalDate.now(), 1, route);
        event.setOwner(user);
        event.setParticipants(Arrays.asList(user, user, user));
        return serializeEvents(Arrays.asList(event, event, event));
    }

    private static List<RoutePoint> createTestRoute() {
        List<RoutePoint> route = new ArrayList<>();
        route.add(new RoutePoint("11", "13", 1));
        route.add(new RoutePoint("33", "23", 2));
        route.add(new RoutePoint("65", "23", 3));
        route.add(new RoutePoint("45", "56", 4));
        route.add(new RoutePoint("34", "22", 5));
        return route;
    }


}
