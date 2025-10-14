package demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String n = request.getParameter("username");
        String p = request.getParameter("userpass");
        
        if(p.equals("pass")) {
            RequestDispatcher rd = request.getRequestDispatcher("Welcome");
            rd.forward(request, response);
        } else {
            out.print("Sorry Username or Password Error");
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.include(request, response);
        }
    }
}
