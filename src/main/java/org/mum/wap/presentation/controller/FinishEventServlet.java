package org.mum.wap.presentation.controller;

import org.mum.wap.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ayman Elakhwas
 */
@WebServlet("/FinishEvent")
public class FinishEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("eventId"));

        EventService eventService = new EventService();
        eventService.finishEvent(eventId);
    }
}
