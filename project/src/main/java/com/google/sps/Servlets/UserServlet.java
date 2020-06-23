package com.google.sps.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import com.google.gson.*;

@WebServlet("/User")
public class UserServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    UserService userService = UserServiceFactory.getUserService();
    if (userService.isUserLoggedIn()) {
      HttpSession session = request.getSession(true);

      String userEmail = userService.getCurrentUser().getEmail();
      User user = Database.getUserByEmail(userEmail);
      session.setAttribute("userID", user.getUserID());
      
    } else {
      request.getSession(false).invalidate();
    }
    response.sendRedirect("login.jsp");
  }
}
