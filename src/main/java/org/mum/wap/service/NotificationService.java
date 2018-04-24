package org.mum.wap.service;

import org.json.simple.JSONObject;
import org.mum.wap.dao.EventDao;
import org.mum.wap.model.Event;

import java.util.List;

public class NotificationService {

    public JSONObject[] getEmergencyNotification(){


      List<Event> event = EventDao.getEvent_status(2);



        return null;
    }
}
