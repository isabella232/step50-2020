// package com.google.sps.servlets;

// import com.google.appengine.api.users.UserService;
// import com.google.appengine.api.users.UserServiceFactory;
// import com.google.gson.*;
// import com.google.sps.models.*;
// import java.io.IOException;
// import java.util.ArrayList;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;

// @WebServlet("/Document")
// public class DocumentServlet extends HttpServlet {
//   @Override
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//     String documentHash = (String) request.getParameter("hash");
//     response.sendRedirect("/document.jsp" + hash);
//   }
// }
