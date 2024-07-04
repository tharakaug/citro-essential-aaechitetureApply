package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.CustomerDAO;
import org.example.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public ArrayList<Customer> getAll() throws SQLException,ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer") ;

        while (rst.next()) {
            Customer customer = new Customer(rst.getString("id"), resultSet.getString("name") , resultSet.getString("address") ,resultSet.getString("tel") );
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    public  boolean save(Customer entity) throws SQLException,ClassNotFoundException {
         return SQLUtil.execute ("INSERT INTO customer VALUES(?, ?, ?, ?)", entity.getId(),entity.getName(),entity.getTel(),entity.getAddress()) ;
    }

    public static boolean update(Customer entity) throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET customer_name  = ?, customer_address = ?, customer_cusContactNO = ? WHERE customer_cusID = ?",entity.getName(),entity.getAddress(),entity.getTel(),entity.getId()) ;
    }

    public static Customer searchById(String id) throws SQLException,ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE customer_cusID = ?",id+ "");
        rst.next();
        return new Customer(id + "", rst.getString("name"), rst.getString("address"),rst.getString("tel"));
    }

    public static boolean delete(String id) throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE customer_cusID = ?",id);
    }

    public static List<String> getId() throws SQLException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT customer_cusID  FROM customer");

        while (resultSet.next()) {
            idList.add(resultSet.getString("customer_cusID"));
        }
        return idList;
    }

}
