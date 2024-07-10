package org.example.dao;

import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    ArrayList<T> getAll() throws SQLException,ClassNotFoundException;

    boolean save(T entity) throws SQLException,ClassNotFoundException;

    boolean update(T entity) throws SQLException,ClassNotFoundException;

    T searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
