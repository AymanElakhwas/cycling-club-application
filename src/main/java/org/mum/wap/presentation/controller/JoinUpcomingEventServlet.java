package org.mum.wap.presentation.controller;

import org.json.simple.JSONArray;
import org.mum.wap.model.User;
import org.mum.wap.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ayman Elakhwas
 */
@WebServlet("/JoinUpcomingEvent")
public class JoinUpcomingEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long eventId = Long.parseLong(request.getParameter("eventId"));
        long userId = ((User) request.getSession().getAttribute("user")).getId();

        EventService eventService = new EventService();
        eventService.joinEvent(eventId, userId);
    }
}
