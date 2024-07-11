package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.CustomerDAO;
import org.example.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws SQLException,ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer") ;

        while (rst.next()) {
            Customer customer = new Customer(rst.getString("customer_cusID"), rst.getString("customer_name") , rst.getString("customer_cusContactNO") ,rst.getString("customer_address") );
            System.out.println(customer);
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public  boolean save(Customer entity) throws SQLException,ClassNotFoundException {
         return SQLUtil.execute ("INSERT INTO customer VALUES(?, ?, ?, ?)", entity.getId(),entity.getName(),entity.getTel(),entity.getAddress()) ;
    }

    @Override
    public  boolean update(Customer entity) throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET customer_name  = ?, customer_address = ?, customer_cusContactNO = ? WHERE customer_cusID = ?",entity.getName(),entity.getAddress(),entity.getTel(),entity.getId()) ;
    }

    @Override
    public  Customer searchById(String id) throws SQLException,ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE customer_cusID = ?",id+ "");
        rst.next();
        return new Customer(id + "", rst.getString("customer_name"), rst.getString("customer_address"),rst.getString("customer_cusContactNO"));
    }

    @Override
    public  boolean delete(String id) throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE customer_cusID = ?",id);
    }

    public static List<String> getId() throws SQLException, ClassNotFoundException {
        List<String> idList = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT customer_cusID  FROM customer");

        while (rst.next()) {
            idList.add(rst.getString("customer_cusID"));
        }
        return idList;
    }

}
