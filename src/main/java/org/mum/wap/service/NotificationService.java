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
        //        private long id;
//        private String title;
//        private String description;
//        private LocalDate startDateTime;
//        private int status;
//        private User owner;
//        private List<User> participants = new ArrayList<>();
//        private List<RoutePoint> route = new ArrayList<>();

        List<Event> eventlist = EventDao.getEventBystatus(2);
        JSONObject[] jsonEventList = new JSONObject[eventlist.size()];
        int count = 0;
        for(Event event1: eventlist){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",event1.getId());
            jsonObject.put("title",event1.getTitle());
            jsonObject.put("description",event1.getDescription());
            jsonEventList[count] = jsonObject;
            count++;
        }

        return jsonEventList;
    }

}
