package edu.uptc.jeeproyect.persistence;

import java.util.List;

public class Meet implements  InterfaceDao<Meet>{
    @Override
    public List<Meet> getAll() {
        return null;
    }

    @Override
    public Meet findById(String id) {
        return null;
    }

    @Override
    public int addRoom(Meet meet) {
        return 0;
    }

    @Override
    public void update(Meet meet) {

    }

    @Override
    public void delete(Meet meet) {

    }

    @Override
    public void close() throws Exception {

    }
}
