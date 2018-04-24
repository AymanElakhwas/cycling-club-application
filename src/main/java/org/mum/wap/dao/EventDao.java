package org.mum.wap.dao;

import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;
import org.mum.wap.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EventDao {

    public static List<Event> getEvent_status(int pStatus) {

        Helper helper=new Helper();
        helper.makeJDBCConnection();
        ResultSet rs=helper.getDataFromDB("SELECT * FROM `event` e INNER JOIN event_rout er on e.id = er.event_id and e.status="+pStatus);

        return toEvent(rs);
    }

    public static List<Event> getEvents() {

        Helper helper=new Helper();
        helper.makeJDBCConnection();
        ResultSet rs=helper.getDataFromDB("SELECT * FROM `event` ");
        List<Event> lstEvents=toEvent(rs);

        String sql="";
        for (Event event:lstEvents) {
            sql+=event.getId()+",";
        }

        ResultSet rs2=helper.getDataFromDB("SELECT * FROM `event_rout` WHERE ID in("+sql.substring(0,sql.length()-1)+")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2,lstEvents);

        for (Event event:lstEvents) {
            ResultSet rsUser=helper.getDataFromDB("SELECT * FROM `user_event` ue inner join user u on u.ID=ue.user_id and ue.event_id="+event.getId());
            ResultSet rsUser2=helper.getDataFromDB("SELECT * FROM `user` WHERE ID="+event.getCreated_by());

            List<User> lstUSer2 = UserDao.toUser(rsUser2);
            List<User> lstUSer = UserDao.toUser(rsUser);

            event.setParticipants(lstUSer);
            event.setRoute(lstRoadPoints.stream().filter(x->x.getEvent().getId()==event.getId()).collect(Collectors.toList()));
            event.setOwner(lstUSer2.stream().filter(z->z.getId()==event.getCreated_by()).collect(Collectors.toList()).get(0));
        }

        helper.closeConnection();

        return lstEvents;
    }

    public static boolean addEvent(Event pEvent) {

        Helper helper=new Helper();
        helper.makeJDBCConnection();

        String insertStatement = "INSERT  INTO  event  VALUES  ("+pEvent.getTitle()+","+pEvent.getDescription()+","+pEvent.getStartDateTime()+","+pEvent.getStatus()+","+pEvent.getOwner().getId()+")";

        return   helper.addDataToDB(insertStatement);

    }


    public static List<Event> getEvent_Id(int pId) {

        Helper helper=new Helper();
        helper.makeJDBCConnection();
        ResultSet rs=helper.getDataFromDB("SELECT * FROM `event` where ID="+pId);

        return toEvent(rs);
    }
    private static List<Event> toEvent(ResultSet rs) {

        List<Event> lstEvents=new ArrayList<>();

        try {

            while (rs.next()) {
                int status = rs.getInt("status");
                LocalDate start_time = rs.getDate("start_time").toLocalDate();
                int id = rs.getInt("ID");
                String description = rs.getString("description");
                String title = rs.getString("title");
                String current_location = rs.getString("current_location");
                int created_by = rs.getInt("created_by");

                Event event =new Event(id, title, description, start_time, status, current_location,created_by);
                lstEvents.add(event);

            }


            return  lstEvents;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    private static List<RoutePoint> toRoadPoint(ResultSet rs,List<Event> lstEvents) {

        List<RoutePoint> lstRoute=new ArrayList<>();

        try {

            while (rs.next()) {
                int point_order = rs.getInt("point_order");
                String point = rs.getString("point");
                int id = rs.getInt("ID");
                int event_id = rs.getInt("event_id");

                lstRoute.add(new RoutePoint( point.split(",")[0], point.split(",")[1],  point_order, lstEvents.stream().filter(x->x.getId()==event_id).collect(Collectors.toList()).get(0)));
            }
            return  lstRoute;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
