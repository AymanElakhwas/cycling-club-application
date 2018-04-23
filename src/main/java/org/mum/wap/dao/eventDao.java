package org.mum.wap.dao;

import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class eventDao {

    public static List<Event> getEvent_status(int pStatus) {

        Helper.makeJDBCConnection();
        ResultSet rs=Helper.getDataFromDB("SELECT * FROM `event` e INNER JOIN event_rout er on e.id = er.event_id and e.status="+pStatus);

        return toEvent(rs);
    }

    private static List<Event> toEvent(ResultSet rs) {

        List<RoutePoint> lstRoute=new ArrayList<>();
        List<Event> lstEvents=new ArrayList<>();

        try {

            while (rs.next()) {
                int status = rs.getInt("status");
                LocalDate start_time = rs.getDate("start_time").toLocalDate();
                int id = rs.getInt("ID");
                String description = rs.getString("description");
                String title = rs.getString("title");
                String current_location = rs.getString("current_location");
                String point = rs.getString("point");
                int point_order = rs.getInt("point_order");
                lstRoute.add(new RoutePoint(point.split(",")[0],point.split(",")[1],point_order));

                lstEvents.add(new Event(id, title, description, start_time, status, current_location, lstRoute));
            }

            Helper.closeConnection();
            return  lstEvents;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
