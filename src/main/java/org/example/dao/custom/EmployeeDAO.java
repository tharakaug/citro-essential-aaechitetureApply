package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Customer;
import org.example.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee> {

    ArrayList<Employee> getAll() throws SQLException,ClassNotFoundException;

    boolean save(Employee entity) throws SQLException,ClassNotFoundException;

    boolean update(Employee entity) throws SQLException,ClassNotFoundException;

    Employee searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;

}
