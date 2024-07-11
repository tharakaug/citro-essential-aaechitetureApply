package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;
import org.example.entity.Machine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    ArrayList<EmployeeDTO> getAll() throws SQLException,ClassNotFoundException;

    boolean save(EmployeeDTO dto) throws SQLException,ClassNotFoundException;

    boolean update(EmployeeDTO dto) throws SQLException,ClassNotFoundException;

    Employee searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;


    List<String> getAllMachineId() throws SQLException, ClassNotFoundException;
}
