package org.mum.wap.presentation.controller;

import org.json.simple.JSONArray;
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
@WebServlet("/GetUpcomingEvents")
public class GetUpcomingEventsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventService es = new EventService();
        JSONArray results = es.getUpcomingEvents();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(results.toJSONString());
        out.flush();
    }
}
