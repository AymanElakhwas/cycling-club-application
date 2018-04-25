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

        return JsonSerializer.serializeEvents(EventDao.getUpcomingEvents());
    }

    public JSONArray getEventRoutePoints(int eventid) {

        return JsonSerializer.serializeRoutePoints(EventDao.getRoutePointsByEventId(eventid));
    }
    public void joinEvent(int eventId, int userId) {
        EventDao.joinEvent(eventId, userId);
    }

    public JSONArray getLiveEvents() {
        List<Event> events = EventDao.getEventBystatus(1);
        return JsonSerializer.serializeEvents(events);
    }

    public JSONArray getEnrolledEvents(int id) {
        List<Event> events = EventDao.getEnrolledEventForUser((int) id);
        return JsonSerializer.serializeEvents(events);
    }

    public JSONArray getMyRideEvents(int id) {
        List<Event> events = EventDao.getMyCreatedEventsForUser(id);
        return JsonSerializer.serializeEvents(events);
    }

    public void startEvent(int eventId) {
        EventDao.updateEventStatus(eventId, 1);
    }

    public void raiseFlagForEvent(int eventId, String location) {
        EventDao.updateEventStatusAndLocation(eventId, 2, location);

    }

    public void finishEvent(int eventId) {
        EventDao.updateEventStatus(eventId, 3);
    }

    public List<RoutePoint> getRoutePoints(String pJsonStr) {
        return JsonDeserializer.deserializeRoutePoints(pJsonStr);
    }
}
