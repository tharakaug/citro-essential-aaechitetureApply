package org.example.bo.custom.Impl;

import org.example.bo.custom.SupplierBO;
import org.example.dao.DAOFactory;
import org.example.dao.SQLUtil;
import org.example.dao.custom.SupplierDAO;
import org.example.entity.Material;
import org.example.entity.Supplier;
import org.example.dto.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean save(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(new Supplier(dto.getId(), dto.getName(), dto.getTel()));
    }

    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new Supplier(dto.getName(), dto.getTel(), dto.getId()));
    }

    @Override
    public Supplier searchById(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.searchById(id);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO> allSupplier = new ArrayList<>();
        ArrayList<Supplier> all = supplierDAO.getAll();

        for (Supplier c : all) {
            allSupplier.add(new SupplierDTO(c.getId(), c.getName(), c.getTel()));
        }
            return allSupplier;
        }
  /*  @Override
    public static List<String> getId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM supplier") ;

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }*/
    }

