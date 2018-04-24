package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mum.wap.dao.EventDao;
import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;

import java.util.List;

/**
 * @author Ayman Elakhwas
 */
public class EventService {
    public JSONArray getUpcomingEvents() {
        return JsonSerializer.serializeEvents(EventDao.getEvents());
    }

    public void joinEvent(long eventId, long userId) {
        //TODO implement join event
    }

    public JSONArray getLiveEvents() {
        List<Event> events = EventDao.getEvents();
        events.remove(0);
        return JsonSerializer.serializeEvents(events);
    }

    public JSONArray getEnrolledEvents(long id) {
        List<Event> events = EventDao.getEvents();
        events.remove(1);
        events.remove(0);
        return JsonSerializer.serializeEvents(events);
    }

    public JSONArray getMyRideEvents() {
        List<Event> events = EventDao.getEvents();
        return JsonSerializer.serializeEvents(events);
    }

    //Abdelrahman
    public List<RoutePoint> getRoutePoints(JSONObject jsonObject) {


        return JsonSerializer.DeserializeRoutePoints(jsonObject);
    }
}
