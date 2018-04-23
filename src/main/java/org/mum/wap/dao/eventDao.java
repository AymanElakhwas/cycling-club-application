package org.mum.wap.dao;

import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class eventDao {

    public static Event getEvent_status(int pStatus) {

        Helper.makeJDBCConnection();
        ResultSet rs=Helper.getDataFromDB("SELECT * FROM `event` e INNER JOIN event_rout er on e.id = er.event_id and e.status="+pStatus);

        return toEvent(rs);
    }

    private static Event toEvent(ResultSet rs) {

        List<RoutePoint> lstRoute=new ArrayList<>();

        try {

            while (rs.next()) {
                int status = rs.getInt("status");
                LocalDate start_time = rs.getDate("start_time").toLocalDate();
                int id = rs.getInt("ID");
                String description = rs.getString("description");
                String title = rs.getString("title");
                String point = rs.getString("point");
                int point_order = rs.getInt("point_order");
                lstRoute.add(new RoutePoint(point.split(",")[0],point.split(",")[1],point_order));

                return new Event(id, title, description, start_time, status, lstRoute);
            }
            Helper.closeConnection();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
