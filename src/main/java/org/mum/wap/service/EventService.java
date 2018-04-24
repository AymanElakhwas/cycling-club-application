package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.mum.wap.dao.EventDao;

/**
 * @author Ayman Elakhwas
 */
public class EventService {
    public JSONArray getUpcomingEvents() {
        return JsonSerializer.serializeEvents(EventDao.getEvents());
        //return JsonSerializer.getMockEventsJson();
    }

    public void joinEvent(long eventId, long userId) {
    }
}
