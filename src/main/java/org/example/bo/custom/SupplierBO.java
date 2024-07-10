package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.SupplierDTO;
import org.example.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    ArrayList<SupplierDTO> getAll() throws SQLException,ClassNotFoundException;

    boolean save(SupplierDTO dto) throws SQLException,ClassNotFoundException;

    boolean update(SupplierDTO dto) throws SQLException,ClassNotFoundException;

    SupplierDTO searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
