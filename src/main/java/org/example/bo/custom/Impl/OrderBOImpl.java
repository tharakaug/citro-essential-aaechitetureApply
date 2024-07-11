package org.example.bo.custom.Impl;

import org.example.bo.custom.OrderBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.OrderDAO;
import org.example.dto.OrderDTO;
import org.example.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public  boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.save(new Order(dto.getId(),dto.getDate(),dto.getCusId())) ;
    }
    @Override
    public  boolean update(OrderDTO dto)throws SQLException,ClassNotFoundException {
        return orderDAO.update(new Order(dto.getId(),dto.getDate(),dto.getCusId())) ;
    }

    @Override
    public Order searchById(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
