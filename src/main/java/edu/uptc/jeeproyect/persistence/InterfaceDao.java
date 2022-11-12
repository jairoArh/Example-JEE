package edu.uptc.jeeproyect.persistence;

import edu.uptc.jeeproyect.logic.Room;

import java.util.List;

public interface InterfaceDao<T> extends AutoCloseable{

    List<T> getAll();

    T findById(String id);

    int addRoom( T t );

    void update(T t);

    void delete( T t );
}
