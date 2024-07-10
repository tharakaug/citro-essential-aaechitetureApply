package org.example.bo.custom.Impl;

import org.example.bo.custom.MachineBO;
import org.example.dao.DAOFactory;
import org.example.dao.SQLUtil;
import org.example.dao.custom.MachineDAO;
import org.example.dto.MachineDTO;
import org.example.entity.Employee;
import org.example.entity.Machine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineBOImpl implements MachineBO {
    MachineDAO machineDAO = (MachineDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MACHINE);
    @Override
    public  boolean save(MachineDTO dto) throws SQLException, ClassNotFoundException {
        return machineDAO.save(new Machine(dto.getId(),dto.getName(),dto.getDesc(),dto.getProId()));
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return machineDAO.delete(id);
    }
    @Override
    public boolean update(MachineDTO dto) throws SQLException, ClassNotFoundException {
        return machineDAO.update( new Machine(dto.getName(), dto.getDesc(), dto.getProId(), dto.getId()));
    }
    @Override
    public Machine searchById(String id) throws SQLException, ClassNotFoundException {

        return machineDAO.searchById(id);
    }


    @Override
    public ArrayList<MachineDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<MachineDTO> allMachine = new ArrayList<>();
        ArrayList<Machine> all = machineDAO.getAll();

      for(Machine c : all){

            allMachine.add(new MachineDTO(c.getId(),c.getName(),c.getDesc(),c.getProId()));

        }
        return allMachine;
    }

    public static List<String> getId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT machine_mashID  FROM machine");

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;

    }
}
