package org.example.dao.custom;

import com.lowagie.text.pdf.AcroFields;
import org.example.dao.CrudDAO;
import org.example.entity.Customer;
import org.example.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item> {
    ArrayList<Item> getAll() throws SQLException,ClassNotFoundException;

    boolean save(Item entity) throws SQLException,ClassNotFoundException;

    boolean update(Item entity) throws SQLException,ClassNotFoundException;

    Item searchById(String id) throws SQLException,ClassNotFoundException;

    boolean delete(String id) throws SQLException,ClassNotFoundException;
}
