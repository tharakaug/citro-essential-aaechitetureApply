package org.example.bo.custom.Impl;

import org.example.bo.custom.CustomerBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.CustomerDAO;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException,ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();

        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getId(), c.getName() , c.getAddress() ,c.getTel()));
        }
        return allCustomers;
    }

    @Override
    public  boolean save(CustomerDTO dto) throws SQLException,ClassNotFoundException {
        return customerDAO.save (new Customer(dto.getId(),dto.getName(),dto.getTel(),dto.getAddress()) ) ;
    }

    @Override
    public  boolean update(CustomerDTO dto) throws SQLException,ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getName(),dto.getAddress(),dto.getTel(),dto.getId())) ;
    }

    @Override
     public Customer searchById(String id) throws SQLException,ClassNotFoundException {
        return customerDAO.searchById(id);
      //  return new Customer(id + "", cu.getString("name"), rst.getString("address"),rst.getString("tel"));
    }

    @Override
    public  boolean delete(String id) throws SQLException,ClassNotFoundException {
        return customerDAO.delete(id);
    }

   /* public static List<String> getId() throws SQLException, ClassNotFoundException {
        List<String> idList = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT customer_cusID  FROM customer");

        while (rst.next()) {
            idList.add(rst.getString("customer_cusID"));
        }
        return idList;
    }*/
}
