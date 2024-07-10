package org.example.bo.custom.Impl;

import org.example.bo.custom.EmployeeBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.EmployeeDAO;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployee = new ArrayList<>();
        ArrayList<Employee> all = employeeDAO.getAll();

        for (Employee c : all) {
            allEmployee.add(new EmployeeDTO(c.getId(), c.getName(), c.getAddress(), c.getTel(), c.getMashId()));

        }
        return allEmployee;
    }

    @Override
    public boolean save(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getId(),dto.getName(),dto.getAddress(),dto.getTel(),dto.getMashId()));

    }

    @Override
    public boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getName(),dto.getAddress(),dto.getTel(),dto.getId(), dto.getMashId()) );
    }

    @Override
    public Employee searchById(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.searchById(id) ;

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);

    }
}
