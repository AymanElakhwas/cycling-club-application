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
        EventDao.joinEvent(eventId, userId);
    }

    public JSONArray getLiveEvents() {
        List<Event> events = EventDao.getEventBystatus(1);
        return JsonSerializer.serializeEvents(events);
    }

    public JSONArray getEnrolledEvents(long id) {
        return JsonSerializer.getMockEventsJson();
    }

    public JSONArray getMyRideEvents() {
        return JsonSerializer.getMockEventsJson();
    }

    public void startEvent(long eventId) {
    }

    public void raiseFlagForEvent(long eventId) {
    }

    public void finishEvent(long eventId) {


    }

    public List<RoutePoint> getRoutePoints(String pJsonStr) {

        return JsonDeserializer.deserializeRoutePoints(pJsonStr);
    }
}
