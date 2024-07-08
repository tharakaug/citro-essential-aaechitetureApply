package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
    ArrayList<Customer> getAll() throws SQLException,ClassNotFoundException;

    boolean save(Customer entity) throws SQLException,ClassNotFoundException;

    boolean update(Customer entity) throws SQLException,ClassNotFoundException;

    Customer searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
