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
    @Override
    public boolean save(Employee entity)throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?, ?, ?, ?,?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getTel(),entity.getMashId());
    }

    @Override
    public  boolean update(Employee entity) throws SQLException,ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET employee_name  = ?, employee_address  = ?,employee_contactNumber   = ? WHERE employee_empID  = ?",entity.getName(),entity.getAddress(),entity.getTel(),entity.getId());
    }
    @Override
    public Employee searchById(String emp_id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE employee_empID = ?",emp_id+"") ;
        resultSet.next();

        return new Employee(emp_id+"", resultSet.getString("employee_name"), resultSet.getString("employee_address"), resultSet.getString("employee_contactNumber"), resultSet.getString("machine_mashID"));
        }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE employee_empID = ?",id);
    }
    @Override
    public  ArrayList<Employee> getAll() throws SQLException,ClassNotFoundException {
        ArrayList<Employee> allEmployee = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee") ;

        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getString("employee_empID"), resultSet.getString("employee_name"), resultSet.getString("employee_address"), resultSet.getString("employee_contactNumber"), resultSet.getString("machine_mashID"));
            allEmployee.add(employee);
        }
        return allEmployee;
    }


    public  List<String> getId() throws SQLException,ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT machine_mashID FROM employee");

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }

}
