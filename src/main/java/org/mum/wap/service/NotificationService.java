package org.mum.wap.service;

import org.json.simple.JSONObject;
import org.mum.wap.dao.EventDao;
import org.mum.wap.model.Event;

public class NotificationService {

    public JSONObject[] getEmergencyNotification(){


        Event event = EventDao.getEvent_status(2);



        return null;
    }
}
