package org.example.controller;

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
import org.example.bo.custom.SupplierBO;
import org.example.dao.custom.SupplierDAO;
import org.example.dto.CustomerDTO;
import org.example.dto.SupplierDTO;
import org.example.entity.Supplier;
import org.example.view.tdm.SupplierTM;
/*import lk.ijse.citroessentional.Util.Regex;
import lk.ijse.citroessentional.model.Supplier;
import lk.ijse.citroessentional.model.tm.SupplierTm;
import lk.ijse.citroessentional.repository.SupplierRepo;*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierFormController {

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<SupplierTM> tblSupplier;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    //private List<Supplier> supplierList = new ArrayList<>();
    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    public void initialize() {
        //this.supplierList = getAllSupplier();
        setCellValueFactory();
        loadSupplierTable();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void loadSupplierTable() {

        tblSupplier.getItems().clear();

try{

    ArrayList<SupplierDTO>  allSupplier = supplierBO.getAll();

        for (SupplierDTO c : allSupplier) {
            tblSupplier.getItems().add(new SupplierTM(c.getId(),c.getName(),c.getTel()));
        }
} catch (SQLException e) {
    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
} catch (ClassNotFoundException e) {
    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
}
    }

   /* private List<Supplier> getAllSupplier() {
        List<Supplier> suppierList = null;
        try {
            suppierList = SupplierDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suppierList;
    }*/

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String tel = txtContact.getText();

        //Supplier supplier = new Supplier(id, name, tel);

        //if (isValid()) {
            try {
                boolean isSaved = supplierBO.save(new SupplierDTO(id,name,tel));
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "supplier saved!").show();
                    initialize();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
      //  }
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
            boolean isDeleted = supplierBO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier deleted!").show();
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
        String tel = txtContact.getText();


       // Supplier supplier = new Supplier(id, name, tel);

        try {
            boolean isUpdated = supplierBO.update(new SupplierDTO(id,name,tel));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier updated!").show();
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
            Supplier supplier = supplierBO.searchById(id);

            if (supplier != null) {
                txtId.setText(supplier.getId());
                txtName.setText(supplier.getName());
                txtContact.setText(supplier.getTel());


            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtSupcontactOnKeyReleased(KeyEvent keyEvent) {
      //  Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.CONTACT, txtContact);
    }

    public void txtSupIDOnKeyReleased(KeyEvent keyEvent) {
        //Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ID, txtId);
    }

    public void txtSupNameOnKeyReleased(KeyEvent keyEvent) {
        //Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.NAME, txtName);
    }

   /* public boolean isValid(){
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ID,txtId)) return false;
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.NAME,txtName)) return false;
        if (!Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.CONTACT,txtContact)) return false;

        return true;
    }*/

}
