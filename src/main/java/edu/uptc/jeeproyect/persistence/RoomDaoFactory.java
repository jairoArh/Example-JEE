package edu.uptc.jeeproyect.persistence;

public class RoomDaoFactory {

    public InterfaceDao createRoomDao(){
        return new RoomDaoImplement();
    }
}
