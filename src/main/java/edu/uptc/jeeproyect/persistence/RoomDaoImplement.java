package edu.uptc.jeeproyect.persistence;

import edu.uptc.jeeproyect.logic.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImplement implements InterfaceDao<Room> {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/meets?allowPublicKeyRetrieval=true&useSSL=false";
    private final String USER = "user_meets";
    private final String PASSWORD = "meets1234";

    @Override
    public List<Room> getAll() {
       try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = "SELECT * FROM rooms";
            ResultSet resultSet = statement.executeQuery(query);
            List<Room> list = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String description = resultSet.getString("description");
                int capacity = resultSet.getInt(3);

                list.add(new Room(id, description, capacity));

            }

            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Room findById(String id) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = "SELECT * FROM rooms WHERE id='" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String idRoom = resultSet.getString(1);
                String description = resultSet.getString(2);
                int capacity = resultSet.getInt(3);

                return new Room(idRoom, description, capacity);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public int addRoom(Room room) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
                String id = room.getId();
                String description = room.getDescription();
                String capacity = Integer.toString( room.getCapacity());

                String query = "INSERT INTO rooms VALUES('" + id + "','" + description +
                        "','" + capacity + "')";

                return statement.executeUpdate( query );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void delete(Room room) {

    }

    @Override
    public void close() throws Exception {

    }
}
