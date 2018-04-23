package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;
import org.mum.wap.model.User;

/**
 * @author Ayman Elakhwas
 *
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
        obj.put("startDateTime", event.getStartDateTime());
        obj.put("status", event.getStatus());

        JSONArray route = new JSONArray();
        event.getRoute().forEach(p -> route.add(serialize(p)));
        obj.put("route", route);
        return obj;
    }


    /*
    public static void main(String[] args) {
        User user = new User(2, "ahmed", "myUserName", "pass", "images/testimg.jpg");
        List<RoutePoint> route = createTestRoute();
        Event event = new Event(1,"title","description", LocalDate.now(),1, route);
        event.setOwner(user);

        System.out.println(serialize(user).toJSONString());

        System.out.println(serialize(event).toJSONString());
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
    */


}
