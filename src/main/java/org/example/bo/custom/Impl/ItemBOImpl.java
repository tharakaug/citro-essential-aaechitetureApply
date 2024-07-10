package org.example.bo.custom.Impl;

import org.example.bo.custom.ItemBO;
import org.example.dao.DAOFactory;
import org.example.dao.SQLUtil;
import org.example.dao.custom.ItemDAO;
import org.example.dto.ItemDTO;
import org.example.entity.Item;
import org.example.entity.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item( dto.getId(), dto.getName(), dto.getPrice(), dto.getQty()) );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item( dto.getId(),dto.getName(), dto.getPrice(), dto.getQty()));
    }



    @Override
    public Item searchById(String pro_id) throws SQLException, ClassNotFoundException {
        return itemDAO.searchById(pro_id) ;
    }
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItem = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();

        for (Item c : all) {

           allItem.add(new ItemDTO(c.getId(), c.getName(), c.getPrice(),c.getQty()));
        }
        return allItem;
    }
   /* @Override
    public static List<String> getId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT product_proID FROM product");

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
    @Override
    public static boolean updateQty(List<OrderDetail> odList) throws SQLException, ClassNotFoundException {
        for (OrderDetail od : odList) {
            if (!updateQty(od)) {
                return false;
            }
        }
        return true;
    }
    @Override
    private static boolean updateQty(OrderDetail entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE product SET product_proQTY  = product_proQTY  - ? WHERE product_proID  = ?", entity.getQty(), entity.getId());

    }*/
}
