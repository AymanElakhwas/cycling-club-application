/**
 * @author Abdelrahman
 * this class is used for retreiving data from data base
 */
package org.mum.wap.dao;

import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;
import org.mum.wap.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class EventDao {

    public static void insertEvent() {
//        Helper.makeJDBCConnection();
    }

    public static List<Event> getEventBystatus(int pStatus) {
        Helper helper = new Helper();
        helper.makeJDBCConnection();
        ResultSet rs = helper.getDataFromDB("SELECT * FROM `event` WHERE status = " + pStatus);
        List<Event> lstEvents = toEvent(rs);
        if (lstEvents.isEmpty()) {
            helper.closeConnection();
            return lstEvents;
        }
        String sql = "";
        for (Event event : lstEvents) {
            sql += event.getId() + ",";
        }

        ResultSet rs2 = helper.getDataFromDB("SELECT * FROM `event_rout` WHERE event_id in(" + sql.substring(0, sql.length() - 1) + ")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2, lstEvents);

        for (Event event : lstEvents) {
            ResultSet rsParticipants = helper.getDataFromDB("SELECT u.ID,u.name,u.img,u.password,u.username FROM `user_event` ue inner join user u on u.ID=ue.user_id and ue.event_id=" + event.getId());
            ResultSet rsUser2 = helper.getDataFromDB("SELECT * FROM `user` WHERE ID=" + event.getCreated_by());

            List<User> lstUSer2 = UserDao.toUser(rsUser2);
            List<User> lstParticipants = UserDao.toUser(rsParticipants);

            event.setParticipants(lstParticipants);
            event.setRoute(lstRoadPoints.stream().filter(x -> x.getEvent().getId() == event.getId()).collect(Collectors.toList()));
            event.setOwner(lstUSer2.stream().filter(z -> z.getId() == event.getCreated_by()).collect(Collectors.toList()).get(0));
        }

        helper.closeConnection();

        return lstEvents;
    }

    public static List<Event> getEvents() {

        Helper helper = new Helper();
        helper.makeJDBCConnection();
        ResultSet rs = helper.getDataFromDB("SELECT * FROM `event` ");
        List<Event> lstEvents = toEvent(rs);

        String sql = "";
        for (Event event : lstEvents) {
            sql += event.getId() + ",";
        }

        ResultSet rs2 = helper.getDataFromDB("SELECT * FROM `event_rout` WHERE event_id in(" + sql.substring(0, sql.length() - 1) + ")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2, lstEvents);

        for (Event event : lstEvents) {
            ResultSet rsParticipants = helper.getDataFromDB("SELECT u.ID,u.name,u.img,u.password,u.username FROM `user_event` ue inner join user u on u.ID=ue.user_id and ue.event_id=" + event.getId());
            ResultSet rsUser2 = helper.getDataFromDB("SELECT * FROM `user` WHERE ID=" + event.getCreated_by());

            List<User> lstUSer2 = UserDao.toUser(rsUser2);
            List<User> lstParticipants = UserDao.toUser(rsParticipants);

            event.setParticipants(lstParticipants);
            event.setRoute(lstRoadPoints.stream().filter(x -> x.getEvent().getId() == event.getId()).collect(Collectors.toList()));
            event.setOwner(lstUSer2.stream().filter(z -> z.getId() == event.getCreated_by()).collect(Collectors.toList()).get(0));
        }

        helper.closeConnection();

        return lstEvents;
    }

    public static long addEvent(String title, String description, LocalDateTime startDateTime, int status, String currentLocation, long created_by) {

        Helper helper = new Helper();
        helper.makeJDBCConnection();

        String insertStatement = "INSERT  INTO  event (title, description, start_time,status,created_by,current_location)  VALUES  ('"+title+"','"+description+"','"+startDateTime+"',"+status+","+created_by+", '"+currentLocation+"')";

        return helper.addDataToDB(insertStatement);

    }

    public static boolean updateEventStatus(int eventId, int status) {

        Helper helper = new Helper();
        helper.makeJDBCConnection();

        String updateStmt = "Update `event` SET status=" + status + " WHERE ID=" + eventId;

        return helper.updateInDB(updateStmt);

    }

    public static boolean updateEventStatusAndLocation(int eventId, int status, String location) {

        Helper helper = new Helper();
        helper.makeJDBCConnection();

        String updateStmt = "Update `event` SET status=" + status + " , current_location='"+location+"' WHERE ID=" + eventId;
        return helper.updateInDB(updateStmt);

    }

    public static Event getEventById(int pId) {
        Helper helper = new Helper();
        helper.makeJDBCConnection();
        ResultSet rs = helper.getDataFromDB("SELECT * FROM `event` where ID=" + pId);
        List<Event> lstEvents = toEvent(rs);

        if (lstEvents.isEmpty()) {
            helper.closeConnection();
            return null;
        }

        String sql = "";
        for (Event event : lstEvents) {
            sql += event.getId() + ",";
        }

        ResultSet rs2 = helper.getDataFromDB("SELECT * FROM `event_rout` WHERE event_id in(" + sql.substring(0, sql.length() - 1) + ")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2, lstEvents);

        for (Event event : lstEvents) {
            ResultSet rsParticipants = helper.getDataFromDB("SELECT u.ID,u.name,u.img,u.password,u.username FROM `user_event` ue inner join user u on u.ID=ue.user_id and ue.event_id=" + event.getId());
            ResultSet rsUser2 = helper.getDataFromDB("SELECT * FROM `user` WHERE ID=" + event.getCreated_by());

            List<User> lstUSer2 = UserDao.toUser(rsUser2);
            List<User> lstParticipants = UserDao.toUser(rsParticipants);

            event.setParticipants(lstParticipants);
            event.setRoute(lstRoadPoints.stream().filter(x -> x.getEvent().getId() == event.getId()).collect(Collectors.toList()));
            event.setOwner(lstUSer2.stream().filter(z -> z.getId() == event.getCreated_by()).collect(Collectors.toList()).get(0));
        }

        helper.closeConnection();
        return lstEvents.get(0);
    }

    public static List<RoutePoint> getRoutePointsByEventId(int pId) {


        Helper helper = new Helper();
        helper.makeJDBCConnection();
        ResultSet rs = helper.getDataFromDB("SELECT * FROM `event` where ID=" + pId);
        List<Event> lstEvents = toEvent(rs);

        if (lstEvents.isEmpty()) {
            helper.closeConnection();
            return new ArrayList<>();
        }

        String sql = "";
        for (Event event : lstEvents) {
            sql += event.getId() + ",";
        }

        ResultSet rs2 = helper.getDataFromDB("SELECT * FROM `event_rout` WHERE event_id in(" + sql.substring(0, sql.length() - 1) + ")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2, lstEvents);

        return lstRoadPoints;
    }

    public static List<Event> getEnrolledEventForUser(int userId) {
        Helper helper = new Helper();
        helper.makeJDBCConnection();
        ResultSet rs = helper.getDataFromDB("SELECT * FROM `event` e INNER JOIN `user_event` ue on e.ID=ue.event_id and ue.user_id=" + userId);
        List<Event> lstEvents = toEvent(rs);

        if (lstEvents.isEmpty()) {
            helper.closeConnection();
            return lstEvents;
        }

        String sql = "";
        for (Event event : lstEvents) {
            sql += event.getId() + ",";
        }

        ResultSet rs2 = helper.getDataFromDB("SELECT * FROM `event_rout` WHERE event_id in(" + sql.substring(0, sql.length() - 1) + ")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2, lstEvents);

        for (Event event : lstEvents) {
            ResultSet rsParticipants = helper.getDataFromDB("SELECT u.ID,u.name,u.img,u.password,u.username FROM `user_event` ue inner join user u on u.ID=ue.user_id and ue.event_id=" + event.getId());
            ResultSet rsUser2 = helper.getDataFromDB("SELECT * FROM `user` WHERE ID=" + event.getCreated_by());

            List<User> lstUSer2 = UserDao.toUser(rsUser2);
            List<User> lstParticipants = UserDao.toUser(rsParticipants);

            event.setParticipants(lstParticipants);
            event.setRoute(lstRoadPoints.stream().filter(x -> x.getEvent().getId() == event.getId()).collect(Collectors.toList()));
            event.setOwner(lstUSer2.stream().filter(z -> z.getId() == event.getCreated_by()).collect(Collectors.toList()).get(0));
        }

        helper.closeConnection();
        return lstEvents;
    }

    public static List<Event> getUpcomingEvents() {
        Helper helper = new Helper();
        helper.makeJDBCConnection();
        LocalDateTime datetime = LocalDateTime.now();
        ResultSet rs = helper.getDataFromDB("SELECT * FROM `event` WHERE `start_time` > '" + datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"' order by start_time desc");
        List<Event> lstEvents = toEvent(rs);

        if (lstEvents.isEmpty()) {
            helper.closeConnection();
            return lstEvents;
        }

        String sql = "";
        for (Event event : lstEvents) {
            sql += event.getId() + ",";
        }

        ResultSet rs2 = helper.getDataFromDB("SELECT * FROM `event_rout` WHERE event_id in(" + sql.substring(0, sql.length() - 1) + ")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2, lstEvents);

        for (Event event : lstEvents) {
            ResultSet rsParticipants = helper.getDataFromDB("SELECT u.ID,u.name,u.img,u.password,u.username FROM `user_event` ue inner join user u on u.ID=ue.user_id and ue.event_id=" + event.getId());
            ResultSet rsUser2 = helper.getDataFromDB("SELECT * FROM `user` WHERE ID=" + event.getCreated_by());

            List<User> lstUSer2 = UserDao.toUser(rsUser2);
            List<User> lstParticipants = UserDao.toUser(rsParticipants);

            event.setParticipants(lstParticipants);
            event.setRoute(lstRoadPoints.stream().filter(x -> x.getEvent().getId() == event.getId()).collect(Collectors.toList()));
            event.setOwner(lstUSer2.stream().filter(z -> z.getId() == event.getCreated_by()).collect(Collectors.toList()).get(0));
        }

        helper.closeConnection();
        return lstEvents;
    }

    private static List<Event> toEvent(ResultSet rs) {
        List<Event> lstEvents = new ArrayList<>();
        try {
            while (rs.next()) {
                int status = rs.getInt("status");
                LocalDate start_time = rs.getDate("start_time").toLocalDate();
                int id = rs.getInt("ID");
                String description = rs.getString("description");
                String title = rs.getString("title");
                String current_location = rs.getString("current_location");
                int created_by = rs.getInt("created_by");

                Event event = new Event(id, title, description, start_time, status, current_location, created_by);
                lstEvents.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstEvents;
    }

    private static List<RoutePoint> toRoadPoint(ResultSet rs, List<Event> lstEvents) {

        List<RoutePoint> lstRoute = new ArrayList<>();

        try {

            while (rs.next()) {
                int point_order = rs.getInt("point_order");
                String point = rs.getString("point");
                int id = rs.getInt("ID");
                int event_id = rs.getInt("event_id");

                String[] splitted = point.split(",");
                lstRoute.add(new RoutePoint(splitted[0], splitted[1], point_order, lstEvents.stream().filter(x -> x.getId() == event_id).collect(Collectors.toList()).get(0)));
            }
            return lstRoute;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static long joinEvent(long eventId, long userId) {
        Helper helper = new Helper();
        helper.makeJDBCConnection();
        String insertStatement = "INSERT  INTO  user_event  (user_id , event_id ) VALUES (" + userId + "," + eventId + ")";
        return helper.addDataToDB(insertStatement);
    }

    public static List<Event> getMyCreatedEventsForUser(int userId) {
        Helper helper = new Helper();
        helper.makeJDBCConnection();
        ResultSet rs = helper.getDataFromDB("SELECT * FROM `event`where created_by=" + userId);
        List<Event> lstEvents = toEvent(rs);

        if (lstEvents.isEmpty()) {
            helper.closeConnection();
            return lstEvents;
        }

        String sql = "";
        for (Event event : lstEvents) {
            sql += event.getId() + ",";
        }
        ResultSet rs2 = helper.getDataFromDB("SELECT * FROM `event_rout` WHERE event_id in(" + sql.substring(0, sql.length() - 1) + ")");

        List<RoutePoint> lstRoadPoints = toRoadPoint(rs2, lstEvents);

        for (Event event : lstEvents) {
            ResultSet rsParticipants = helper.getDataFromDB("SELECT u.ID,u.name,u.img,u.password,u.username FROM `user_event` ue inner join user u on u.ID=ue.user_id and ue.event_id=" + event.getId());
            ResultSet rsUser2 = helper.getDataFromDB("SELECT * FROM `user` WHERE ID=" + event.getCreated_by());

            List<User> lstUSer2 = UserDao.toUser(rsUser2);
            List<User> lstParticipants = UserDao.toUser(rsParticipants);

            event.setParticipants(lstParticipants);
            event.setRoute(lstRoadPoints.stream().filter(x -> x.getEvent().getId() == event.getId()).collect(Collectors.toList()));
            event.setOwner(lstUSer2.stream().filter(z -> z.getId() == event.getCreated_by()).collect(Collectors.toList()).get(0));
        }

        helper.closeConnection();
        return lstEvents;
    }
}
