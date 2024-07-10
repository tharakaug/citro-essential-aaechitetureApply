package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.MachineDTO;
import org.example.entity.Machine;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MachineBO extends SuperBO {
    ArrayList<MachineDTO> getAll() throws SQLException,ClassNotFoundException;

    boolean save(MachineDTO dto) throws SQLException,ClassNotFoundException;

    boolean update(MachineDTO dto) throws SQLException,ClassNotFoundException;

    Machine searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
