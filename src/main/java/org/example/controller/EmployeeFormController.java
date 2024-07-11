package org.example.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBO;
import org.example.bo.custom.EmployeeBO;
import org.example.dao.custom.EmployeeDAO;
import org.example.dao.custom.MachineDAO;
import org.example.dto.CustomerDTO;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;
import org.example.entity.Machine;
import org.example.view.tdm.CustomerTM;
import org.example.view.tdm.EmployeeTM;
/*import lk.ijse.citroessentional.Util.Regex;
import lk.ijse.citroessentional.model.Employee;
import lk.ijse.citroessentional.model.Machine;
import lk.ijse.citroessentional.model.tm.EmployeeTm;
import lk.ijse.citroessentional.repository.EmployeeRepo;
import lk.ijse.citroessentional.repository.MachineRepo;*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<EmployeeTM> tblEmployee;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXComboBox<String> cmbMachineID;


    //private List<Employee> employeeList = new ArrayList<>();
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    public void initialize() throws SQLException {
        //this.employeeList = getAllemployee();
        setCellValueFactory();
        loadEmployeeTable();
         setComboBoxValue();
    }

    private void setComboBoxValue()  {
        ObservableList<String> obList = FXCollections.observableArrayList();

        List<String> all = null;
        try {
            all = employeeBO.getAllMachineId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (String id : all) {
                obList.add(id);
            }
            cmbMachineID.setItems(obList);

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void loadEmployeeTable() {

        tblEmployee.getItems().clear();
        try{
            ArrayList<EmployeeDTO>  allEmployee = employeeBO.getAll();

            for (EmployeeDTO c : allEmployee) {
                tblEmployee.getItems().add(new EmployeeTM(c.getId(), c.getName(), c.getTel(), c.getAddress(), c.getMashId()));}
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    /*private ArrayList<EmployeeDTO> getAllemployee() {
        ArrayList<EmployeeDTO> employeeList = null;
        try {
            employeeList = EmployeeDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }*/

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtContact.getText();
        String mashId = cmbMachineID.getValue();

        //   Employee employee = new Employee(id, name, address, tel,mashId);

        // if (isValid()) {
        try {
            boolean isSaved = employeeBO.save(new EmployeeDTO(id, name, address, tel, mashId));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee saved!").show();
                // loadEmployeeTable();
                initialize();

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
            // }
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException,ClassNotFoundException {
        String id = txtId.getText();

        try {
            boolean isDeleted = employeeBO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtContact.getText();
        String mashId = cmbMachineID.getValue();

        //  Employee employee = new Employee(id, name, address, tel,mashId);

        try {
            boolean isUpdated = employeeBO.update(new EmployeeDTO(id,name,address,tel,mashId));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            Employee employee = employeeBO.searchById(id);

            if (employee != null) {
                txtId.setText(employee.getId());
                txtName.setText(employee.getName());
                txtAddress.setText(employee.getAddress());
                txtContact.setText(employee.getTel());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtEmployeeIDOnKeyReleased(KeyEvent keyEvent) {
        // Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ID,txtId);
    }
    public void txtEmployeeNameOnKeyReleased(KeyEvent keyEvent) {
        //     Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.NAME,txtName);
    }

    public void txtEmployeeAddressOnKeyReleased(KeyEvent keyEvent) {
        //   Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ADDRESS,txtAddress);
    }

    public void txtEmplooyeeContactOnKeyReleased(KeyEvent keyEvent) {
        //    Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.CONTACT,txtContact);
    }


   /* public boolean isValid(){
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ID,txtId)) return false;
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.CONTACT,txtContact)) return false;
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.NAME,txtName)) return false;
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ADDRESS,txtAddress)) return false;

        return true;
    }*/

    public void cmbMachineIDOnAction(ActionEvent actionEvent) {

    }
}
