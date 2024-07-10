package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.ItemDTO;
import org.example.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    ArrayList<ItemDTO> getAll() throws SQLException,ClassNotFoundException;

    boolean save(ItemDTO dto) throws SQLException,ClassNotFoundException;

    boolean update(ItemDTO dto) throws SQLException,ClassNotFoundException;

    Item searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
