package org.example.dao.custom.impl;

import org.example.dao.SQLUtil;
import org.example.dao.custom.MachineDAO;
import org.example.entity.Item;
import org.example.entity.Machine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineDAOImpl implements MachineDAO {
    public  boolean save(Machine entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO machine VALUES(?, ?, ?,?)",entity.getId(),entity.getName(),entity.getDesc(),entity.getProId());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM machine WHERE  machine_mashID = ?",id);
    }

    public boolean update(Machine entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE machine SET  machine_machineName  = ?, machine_machineDecs = ?,product_proID =? WHERE machine_mashID  = ?",entity.getName(),entity.getDesc(),entity.getProId(), entity.getId());
    }

    public Machine searchById(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM machine WHERE machine_mashID = ?",id+"") ;
        resultSet.next();

            return new Machine(id+"",resultSet.getString("machine_machineName"), resultSet.getString("machine_machineDecs"),resultSet.getString("product_proID"));
    }

    public  ArrayList<Machine> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Machine> allMachine = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM machine") ;
        while (resultSet.next()) {

            Machine machine = new Machine(resultSet.getString("machine_mashID"), resultSet.getString("machine_machineName"), resultSet.getString("machine_machineDecs"), resultSet.getString("product_proID"));
            allMachine.add(machine);
        }
        return allMachine;
    }
    

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
           List <String> idList =new ArrayList<>();
           ResultSet rst = SQLUtil.execute("SELECT machine_mashID FROM machine");
           while (rst.next()){
            idList.add(rst.getString(1));
        }
            return idList;
            }
         }
