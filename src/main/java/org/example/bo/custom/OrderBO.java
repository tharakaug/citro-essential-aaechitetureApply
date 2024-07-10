package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.OrderDTO;
import org.example.entity.Order;

import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    boolean update(OrderDTO dto) throws SQLException,ClassNotFoundException;
}
