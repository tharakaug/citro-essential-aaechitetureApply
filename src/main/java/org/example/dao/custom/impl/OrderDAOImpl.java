package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.OrderDAO;
import org.example.entity.Order;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean save(Order entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO orders VALUES(?, ?, ?)",entity.getId(),entity.getDate(),entity.getCusId()) ;
    }

    public  boolean update(Order entity)throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("UPDATE orders SET  orders_orderID  = ?, orders_orderDate = ?,customer_cusID  =? WHERE orders_orderID  = ?",entity.getId(),entity.getDate(),entity.getCusId(),entity.getId()) ;
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
