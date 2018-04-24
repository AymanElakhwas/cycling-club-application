package org.mum.wap.presentation.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mum.wap.model.User;
import org.mum.wap.service.EventService;
import org.mum.wap.service.JsonSerializer;

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
@WebServlet("/GetLiveEvents")
public class GetLiveEventsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventService es = new EventService();

        JSONArray events = es.getLiveEvents();
        JSONObject result = new JSONObject();
        User user = (User) request.getSession().getAttribute("user");
        result.put("user", JsonSerializer.serialize(user));
        result.put("events",events);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result.toJSONString());
        out.flush();
    }
}
