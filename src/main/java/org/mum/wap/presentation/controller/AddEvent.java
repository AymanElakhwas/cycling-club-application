package org.mum.wap.presentation.controller;


import org.mum.wap.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String markers=request.getParameter("markers");
        String title=request.getParameter("title");
        String date=request.getParameter("date");
        String description=request.getParameter("description");

        EventService es = new EventService();
        es.getRoutePoints(markers);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
