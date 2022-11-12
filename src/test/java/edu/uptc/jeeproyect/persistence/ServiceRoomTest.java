package edu.uptc.jeeproyect.persistence;

import com.google.gson.Gson;
import edu.uptc.jeeproyect.logic.Room;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceRoomTest {

    @Test
    void getAll() {
        ServiceRoom serviceRoom = new ServiceRoom();


        List<Room> rooms = serviceRoom.getAll();

        rooms.forEach( System.out::println);
    }
}