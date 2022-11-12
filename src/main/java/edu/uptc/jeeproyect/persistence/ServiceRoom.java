package edu.uptc.jeeproyect.persistence;

import edu.uptc.jeeproyect.logic.Room;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRoom {
    private RoomDaoImplement roomDaoImplement;

    public ServiceRoom() {
        roomDaoImplement = new RoomDaoImplement();
    }

    public List<Room> getAll(){

        List<Room> list =roomDaoImplement.getAll();

        return list;
    }

    /***
     * Método que recibe un arreglo de String con los datos de la Sala, pàra persistencia
     * @param data arreglo con los datos
     * @return true si persiste, false si no,
     */
    public boolean save(String ... data ){
        //Convertimos los datos a los tipos de datos del objeto Room
        String id = data[0];
        String description = data[1];
        int capacity = Integer.parseInt( data[2]);

        return roomDaoImplement.addRoom( new Room(id,description,capacity)) > 0;

    }
}
