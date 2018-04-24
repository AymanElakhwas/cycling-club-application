package org.mum.wap.presentation.controller;

import org.json.simple.JSONObject;
import org.mum.wap.service.NotificationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @Author Elham
 * @Date 04/23/1018
 *
 * This servlet is responsible to resoponse to Ajax call which need to recieve emergency events
 *
 */
@WebServlet("/Notification")
public class NotificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        NotificationService notificationService = new NotificationService();
        JSONObject[] jsonObjects = notificationService.getEmergencyNotification();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print(Arrays.toString(jsonObjects));
        out.flush();

    }
}
