package edu.uptc.jeeproyect.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletExample", value = "/ServletExample")
public class ServletExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        int numOne = Integer.parseInt(request.getParameter("nOne"));
        int numTwo = Integer.parseInt(request.getParameter("nTwo"));


        PrintWriter out = response.getWriter();

        out.print( numOne +  numTwo );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
