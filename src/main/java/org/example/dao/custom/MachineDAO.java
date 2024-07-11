package org.example.dao.custom;

import org.example.dao.CrudDAO;
import org.example.entity.Employee;
import org.example.entity.Machine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MachineDAO extends CrudDAO<Machine> {

    List<String> getIds() throws SQLException, ClassNotFoundException;
}
