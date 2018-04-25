package org.mum.wap.service;

import org.json.simple.JSONObject;
import org.mum.wap.dao.EventDao;
import org.mum.wap.model.Event;

import java.util.List;

/**
 * @Author Elham
 * @Date 04/23/2018
 *
 * This service class is responsible to get all notification from server and show to client
 *
 */
public class NotificationService {

    public static void main(String[] arga){
        NotificationService notificationService = new NotificationService();
        notificationService.getEmergencyNotification();
    }

    public JSONObject[] getEmergencyNotification(){

        List<Event> eventlist = EventDao.getEventBystatus(2);
        JSONObject[] jsonEventList = new JSONObject[eventlist.size()];
        int count = 0;
        for(Event event: eventlist){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",event.getId());
            jsonObject.put("title",event.getTitle());
            jsonObject.put("description",event.getDescription());
            jsonObject.put("currentlocation",event.getCurrentLocation());
            jsonEventList[count] = jsonObject;
            count++;
        }

        return jsonEventList;
    }

}
