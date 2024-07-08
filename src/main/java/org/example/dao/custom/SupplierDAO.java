package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Employee;
import org.example.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<Supplier> {
    ArrayList<Supplier> getAll() throws SQLException,ClassNotFoundException;

    boolean save(Supplier entity) throws SQLException,ClassNotFoundException;

    boolean update(Supplier entity) throws SQLException,ClassNotFoundException;

    Supplier searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
