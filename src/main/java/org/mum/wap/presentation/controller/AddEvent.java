package org.mum.wap.presentation.controller;


import org.mum.wap.dao.EventDao;
import org.mum.wap.dao.RoutePointDao;
import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;
import org.mum.wap.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String markers=request.getParameter("markers");
        String title=request.getParameter("title");
        String date=request.getParameter("date");
        String description=request.getParameter("description");

        EventService es = new EventService();
        List<RoutePoint> lstPoints=  es.getRoutePoints(markers);


        //Instant instant = Instant.parse(date);
        //LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

        LocalDateTime result= LocalDateTime.now();
       long eventId= EventDao.addEvent(title,description,result,0,"",1);


        for (RoutePoint routePoint:lstPoints) {

            RoutePointDao.addRoutePoint(routePoint.getLat()+","+routePoint.getLon(),routePoint.getOrder(),Math.toIntExact(eventId));
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
