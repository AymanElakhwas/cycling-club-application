package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.mum.wap.dao.EventDao;

/**
 * @author Ayman Elakhwas
 */
public class EventService {
    public JSONArray getUpcomingEvents() {
        return JsonSerializer.serializeEvents(EventDao.getEvents());
    }
}
