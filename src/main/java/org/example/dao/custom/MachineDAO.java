package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Employee;
import org.example.entity.Machine;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MachineDAO extends CrudDAO<Machine> {
    ArrayList<Machine> getAll() throws SQLException,ClassNotFoundException;

    boolean save(Machine entity) throws SQLException,ClassNotFoundException;

    boolean update(Machine entity) throws SQLException,ClassNotFoundException;

    Machine searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
