package edu.uptc.jeeproyect.persistence;

import edu.uptc.jeeproyect.logic.Room;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomDaoImplementTest {

    private RoomDaoFactory factory = new RoomDaoFactory();

    @Test
    void getAll() {
        InterfaceDao room = factory.createRoomDao();
        List<Room> rooms = room.getAll();
        assertNotNull( rooms );
        assertEquals(11,rooms.size());
        rooms.forEach( System.out::println );
    }

    @Test
    void findById() {
        InterfaceDao interfaceDao = factory.createRoomDao();
        Room room = (Room) interfaceDao.findById("S7");
        assertNotNull(room);
        assertEquals("Sala de Informatica 7",room.getDescription());
        assertEquals(20,room.getCapacity());
        assertNull( interfaceDao.findById("No Eziste"));
    }

    @Test
    void addRoom() {
        InterfaceDao interfaceDao = factory.createRoomDao();
        assertEquals(1, interfaceDao.addRoom( new Room("Sala101","Laboratorio",56)));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}