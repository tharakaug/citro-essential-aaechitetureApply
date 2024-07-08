package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.EmployeeDAO;
import org.example.entity.Customer;
import org.example.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean save(Employee entity)throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?, ?, ?, ?,?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getTel(),entity.getMashId());
    }

    public  boolean update(Employee entity) throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET employee_name  = ?, employee_address  = ?,employee_contactNumber   = ? WHERE employee_empID  = ?",entity.getName(),entity.getAddress(),entity.getTel(),entity.getId());
    }

    public Employee searchById(String emp_id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE employee_empID = ?",emp_id+"") ;
        resultSet.next();

        return new Employee(emp_id+"", resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("tel"), resultSet.getString("mashId"));
        }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE employee_empID = ?",id);
    }

    public  ArrayList<Employee> getAll() throws SQLException,ClassNotFoundException {
        ArrayList<Employee> allEmployee = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee") ;

        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("tel"), resultSet.getString("mashId"));
            allEmployee.add(employee);
        }
        return allEmployee;
    }

    public static List<String> getId() throws SQLException,ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM employee");

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }

}
