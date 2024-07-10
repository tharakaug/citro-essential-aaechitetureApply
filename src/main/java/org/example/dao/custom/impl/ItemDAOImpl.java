package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.ItemDAO;
import org.example.entity.Employee;
import org.example.entity.Item;
import org.example.entity.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item entity)throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO product VALUES(?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getPrice(),entity.getPrice());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM product WHERE product_proID = ?",id);
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE product SET product_proname  = ?, product_price = ?, product_proQTY = ? WHERE product_proID = ?",entity.getName(),entity.getPrice(),entity.getQty(),entity.getId());
    }

    @Override
    public  Item searchById(String pro_id) throws SQLException,ClassNotFoundException{
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM product WHERE product_proID = ?",pro_id+"");
        resultSet.next();
        
            return new Item(pro_id+"", resultSet.getString("name"),resultSet.getDouble("price"),resultSet.getInt("qty"));
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItem = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM product");
        while (resultSet.next()) {
            Item item = new Item(resultSet.getString("id"), resultSet.getString("name"), resultSet.getDouble("price"),resultSet.getInt("qty"));
            allItem.add(item);
        }
        return allItem;
    }


    public static List<String> getId() throws SQLException,ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT product_proID FROM product");

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }

    public static boolean updateQty(List<OrderDetail> odList) throws SQLException, ClassNotFoundException {
        for (OrderDetail od : odList) {
            if(!updateQty(od)) {
                return false;
            }
        }
        return true;
    }


    private static boolean updateQty(OrderDetail entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE product SET product_proQTY  = product_proQTY  - ? WHERE product_proID  = ?", entity.getQty(), entity.getId());

    }
}
