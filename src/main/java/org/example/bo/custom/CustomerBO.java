package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
     ArrayList<CustomerDTO> getAll() throws SQLException,ClassNotFoundException;

    boolean save(CustomerDTO dto) throws SQLException,ClassNotFoundException;

    boolean update(CustomerDTO dto) throws SQLException,ClassNotFoundException;

    Customer searchById(String id) throws SQLException,ClassNotFoundException;

     boolean delete(String id) throws SQLException,ClassNotFoundException;
    

}
