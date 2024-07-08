package org.example.bo.custom.Impl;

import org.example.bo.custom.CustomerBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.CustomerDAO;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

}
