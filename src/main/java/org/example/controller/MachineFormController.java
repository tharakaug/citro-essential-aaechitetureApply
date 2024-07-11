package org.example.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.CustomerBO;
import org.example.bo.custom.MachineBO;
import org.example.dto.CustomerDTO;
import org.example.dto.MachineDTO;
import org.example.entity.Item;
import org.example.entity.Machine;

/*import lk.ijse.citroessentional.Util.Regex;
import lk.ijse.citroessentional.model.Item;
import lk.ijse.citroessentional.model.Machine;
import lk.ijse.citroessentional.model.tm.MachineTm;
import lk.ijse.citroessentional.repository.ItemRepo;
import lk.ijse.citroessentional.repository.MachineRepo;*/
import org.example.dao.custom.ItemDAO;
import org.example.dao.custom.MachineDAO;
import org.example.view.tdm.MachineTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineFormController {

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<MachineTM> tblMachine;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private ComboBox<String> cmbProID;


    //private List<Machine> machineList = new ArrayList<>();
    MachineBO machineBO = (MachineBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MACHINE);


    public void initialize() throws SQLException {
        //this.machineList = getAllMachine();
        setCellValueFactory();
        loadMachineTable();
        //setComboBoxValue();
    }

    /*private void setComboBoxValue() throws SQLException {
        List<Item> all = ItemDAO.getAll();

        ObservableList obList = FXCollections.observableArrayList();
        for (Item item :all) {
            obList.add(item.getId());
        }
        cmbProID.setItems(obList);
    }*/

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("desc"));
    }

    private void loadMachineTable() {

        tblMachine.getItems().clear();

        try{
            ArrayList<MachineDTO>  allMachine = machineBO.getAll();

        for (MachineDTO C : allMachine) {
            tblMachine.getItems().add(new MachineTM(C.getId(), C.getName(), C.getDesc(),C.getProId()));
        }
        }catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
    }

    /*private List<Machine> getAllMachine() {
        List<Machine> machineList = null;
        try {
            machineList = MachineDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return machineList;
    }*/

@FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String desc = txtDescription.getText();
        String proId = cmbProID.getValue();


       // Machine machine = new Machine(id, name, desc, proId);

       // if (isValid()) {
            try {
                boolean isSaved = machineBO.save(new MachineDTO(id,name,desc,proId));
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "machine saved!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }



    @FXML
    void btnBackOnAction(ActionEvent event)throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = machineBO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "machine deleted!").show();
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
        String desc = txtDescription.getText();
        String proId = cmbProID.getValue();


        //Machine machine = new Machine(id, name, desc,proId);

        try {
            boolean isUpdated = machineBO.update(new MachineDTO(id,name,desc,proId));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "machine updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            Machine machine = machineBO.searchById(id);

            if (machine != null) {
                txtId.setText(machine.getId());
                txtName.setText(machine.getName());
                txtDescription.setText(machine.getDesc());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtIMachineIDOnKeyReleased(KeyEvent keyEvent) {
        //Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ID,txtId);
    }


    public void txtIMachineNameOnKeyReleased(KeyEvent keyEvent) {
      //  Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.NAME,txtName);
    }

    public void txtIMachineDescOnKeyReleased(KeyEvent keyEvent) {
       // Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.DESCRIPTION,txtDescription);
    }
   /* public boolean isValid(){
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ID,txtId)) return false;
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.NAME,txtName)) return false;
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.DESCRIPTION,txtDescription)) return false;

        return true;
    }*/

}
