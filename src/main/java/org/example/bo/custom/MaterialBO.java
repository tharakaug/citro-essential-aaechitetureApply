package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.MaterialDTO;
import org.example.entity.Material;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MaterialBO extends SuperBO {
    ArrayList<MaterialDTO> getAll() throws SQLException,ClassNotFoundException;

    boolean save(MaterialDTO dto) throws SQLException,ClassNotFoundException;

    boolean update(MaterialDTO dto) throws SQLException,ClassNotFoundException;

    MaterialDTO searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
