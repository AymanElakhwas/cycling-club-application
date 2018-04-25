package org.mum.wap.presentation.controller;


import org.mum.wap.dao.EventDao;
import org.mum.wap.dao.RoutePointDao;
import org.mum.wap.model.Event;
import org.mum.wap.model.RoutePoint;
import org.mum.wap.model.User;
import org.mum.wap.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");

        String str =date.replace("T"," ");// "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime result = LocalDateTime.parse(str, formatter);

       long eventId= EventDao.addEvent(title,description,result,0,"",user.getId());


        for (RoutePoint routePoint:lstPoints) {

            RoutePointDao.addRoutePoint(routePoint.getLat()+","+routePoint.getLon(),routePoint.getOrder(),Math.toIntExact(eventId));
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
