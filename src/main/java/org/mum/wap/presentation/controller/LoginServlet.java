package org.mum.wap.presentation.controller;

import org.mum.wap.model.User;
import org.mum.wap.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author Elham
 * @Date 04/23/2018
 *  This is login servlet which validate user name and password  of client and send them to index.jsp
 *  page is they are registered and send the error if they are not registered
 *  This servlet also add session and user information for later usage in the applicaiton
 *
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = new LoginService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = loginService.checkCredential(username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        boolean isValidUser = user != null ? true : false;
        RequestDispatcher view = null;

        if(isValidUser){
            HttpSession session = request.getSession();
            session.setAttribute("user" , user);
            view = request.getRequestDispatcher("index.jsp");
            view.forward(request,response);
        }else {
            request.setAttribute("error","error");
            view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
