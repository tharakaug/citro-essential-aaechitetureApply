package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.OrderDTO;
import org.example.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {

    ArrayList<Order> getAll() throws SQLException, ClassNotFoundException;

    boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;

    boolean update(OrderDTO dto)throws SQLException,ClassNotFoundException;

    Order searchById(String id) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;
}
