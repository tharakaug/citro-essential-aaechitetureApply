package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Machine;
import org.example.entity.Material;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MaterialDAO extends CrudDAO<Material> {
    ArrayList<Material> getAll() throws SQLException,ClassNotFoundException;

    boolean save(Material entity) throws SQLException,ClassNotFoundException;

    boolean update(Material entity) throws SQLException,ClassNotFoundException;

    Material searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
