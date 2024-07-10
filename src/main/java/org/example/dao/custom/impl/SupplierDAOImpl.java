package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.SupplierDAO;
import org.example.entity.Material;
import org.example.entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    public boolean save(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO supplier VALUES(?, ?, ?)",entity.getId(),entity.getName(),entity.getTel()) ;
    }

    public boolean update(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE supplier SET supplier_supName   = ?, supplier_contactNO  = ? WHERE supplier_supID  = ?",entity.getName(),entity.getTel(),entity.getId()) ;
    }

    public  Supplier searchById(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM supplier WHERE supplier_supID = ?",id+"") ;
        resultSet.next();

            return new Supplier(id+"",resultSet.getString("name"),resultSet.getString("tel"));
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM supplier WHERE supplier_supID = ?",id) ;
    }

    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Supplier> allSupplier = new ArrayList<>();

        ResultSet resultSet=SQLUtil.execute("SELECT * FROM supplier") ;
        while (resultSet.next()) {
            Supplier supplier = new Supplier(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("tel"));
            allSupplier.add(supplier);
        }
        return allSupplier;
    }

    public static List<String> getId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM supplier") ;

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
}
