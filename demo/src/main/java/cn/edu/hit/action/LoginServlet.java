package cn.edu.hit.action;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        if(username.equals("admin") && password.equals("123"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            String remberMe = request.getParameter("remberMe");
            if(remberMe != null)
            {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }
            response.sendRedirect("index.jsp");
        }else
        {
            response.sendRedirect("login.html");
        }

        // Hello

    }
}