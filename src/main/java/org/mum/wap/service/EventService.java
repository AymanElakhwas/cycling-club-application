package org.mum.wap.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Ayman Elakhwas
 */
public class EventService {
    public JSONArray getUpcomingEvents() {

        return JsonSerializer.getMockEventsJson();
    }
}
