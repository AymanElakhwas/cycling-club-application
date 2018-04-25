package org.mum.wap.presentation.controller;

import org.mum.wap.dao.EventDao;
import org.mum.wap.model.Event;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Autho
 */
@WebServlet("/EventDetails")
public class EventDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventid = Integer.valueOf(request.getParameter("eventid"));
        Event event = EventDao.getEventById(eventid);
        request.setAttribute("Event" , event);
        request.getRequestDispatcher("event-details.jsp").forward(request,response);

    }

}
