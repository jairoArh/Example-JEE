package edu.uptc.jeeproyect.servlets;

import com.google.gson.Gson;
import edu.uptc.jeeproyect.logic.Room;
import edu.uptc.jeeproyect.persistence.ServiceRoom;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletRoom", value = "/ServletRoom")
public class ServletRoom extends HttpServlet {
    private ServiceRoom serviceRoom;

    public void init(){
        serviceRoom = new ServiceRoom();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        List<Room> rooms = serviceRoom.getAll();

        //rooms.forEach(System.out::println);

        Gson gson = new Gson();

        out.print(gson.toJson( rooms));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        String id = request.getParameter("id");
        String desc = request.getParameter("desc");
        String cap = request.getParameter("cap");

        try( PrintWriter out = response.getWriter()){
            if( serviceRoom.save(id,desc,cap)){
                out.print("{\"state\":true}");
            }else{
                out.print("{\"state\":false}");
            }
        }
    }
}
