package org.mum.wap.dao;

import org.mum.wap.model.Event;

import java.time.LocalDateTime;

public class RoutePointDao {


    public RoutePointDao(){}

    public static long addRoutePoint(String point, int pointOrder, int eventId) {

        Helper helper = new Helper();
        helper.makeJDBCConnection();

        String insertStatement = "INSERT INTO `event_rout` (`ID`, `point`, `point_order`, `event_id`) VALUES (NULL, '"+point+"', '"+pointOrder+"', '"+eventId+"');";

        return helper.addDataToDB(insertStatement);

    }

}
