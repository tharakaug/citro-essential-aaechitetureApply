package org.example.bo.custom.Impl;

import org.example.bo.custom.MaterialBO;
import org.example.dao.DAOFactory;
import org.example.dao.SQLUtil;
import org.example.dao.custom.MaterialDAO;
import org.example.dto.MaterialDTO;
import org.example.entity.Machine;
import org.example.entity.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialBOImpl implements MaterialBO {
    MaterialDAO materialDAO = (MaterialDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MATERIAL);
    @Override
    public boolean save(MaterialDTO dto) throws SQLException,ClassNotFoundException {
        return materialDAO.save (new Material(dto.getId(),dto.getName(),dto.getQty(),dto.getPrice())) ;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return materialDAO.delete(id);
    }
    @Override
    public boolean update(MaterialDTO dto) throws SQLException, ClassNotFoundException {
        return materialDAO.update(new Material(dto.getName(),dto.getQty(),dto.getPrice(),dto.getId())) ;
    }
    @Override
    public Material searchById(String id) throws SQLException, ClassNotFoundException {
        return materialDAO.searchById(id);
    }
    @Override
    public ArrayList<MaterialDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<MaterialDTO> allMaterial = new ArrayList<>();
        ArrayList<Material> all = materialDAO.getAll();

        for (Material c : all) {
            allMaterial.add(new MaterialDTO(c.getId(), c.getName(), c.getQty(), c.getPrice()));
        }
        return allMaterial;


      /*  public static List<String> getId () throws SQLException, ClassNotFoundException {
            ResultSet resultSet = SQLUtil.execute("SELECT material_MID FROM material");

            List<String> idList = new ArrayList<>();

            while (resultSet.next()) {
                idList.add(resultSet.getString(1));
            }
            return idList;
        }*/
    }
}
