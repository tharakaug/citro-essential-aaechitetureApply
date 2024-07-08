package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.MaterialDAO;
import org.example.entity.Machine;
import org.example.entity.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAOImpl implements MaterialDAO {

    public boolean save(Material entity) throws SQLException,ClassNotFoundException {
         return SQLUtil.execute("INSERT INTO material VALUES(?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getQty(),entity.getPrice()) ;
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM material WHERE material_MID = ?",id);
    }

    public boolean update(Material entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE material SET  material_matDesc  = ?, material_matQTY  = ?, material_unitprice  = ? WHERE material_MID = ?",entity.getName(),entity.getQty(),entity.getPrice(),entity.getId()) ;
    }

    public  Material searchById(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM material WHERE material_MID = ?",id+"") ;
        resultSet.next();

           return new Material(id+"", resultSet.getString("name"),resultSet.getString("qty"),resultSet.getString("price"));
    }

    public  ArrayList<Material> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Material> allMaterial = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM material");

        while (resultSet.next()) {
            Material material = new Material(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("qty"),resultSet.getString("price"));
            allMaterial.add(material);
        }
        return allMaterial;
    }

    public static List<String> getId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.execute("SELECT material_MID FROM material") ;

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
}
