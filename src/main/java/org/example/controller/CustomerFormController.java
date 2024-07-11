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
import org.example.dao.custom.CustomerDAO;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.view.tdm.CustomerTM;
/*import lk.ijse.citroessentional.Util.Regex;
import lk.ijse.citroessentional.Util.TextField;
import lk.ijse.citroessentional.model.Customer;
import lk.ijse.citroessentional.model.tm.CustomerTm;
import lk.ijse.citroessentional.repository.CustomerRepo;*/

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



//import static jdk.internal.agent.Agent.getText;


public class CustomerFormController {

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
    private TableView<CustomerTM> tblCustomers;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    // private List<Customer> customerList = new ArrayList<>();

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    public void initialize() {
        //this.customerList = getAllCustomers();
        setCellValueFactory();
        loadCustomerTable();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    private void loadCustomerTable() {

        tblCustomers.getItems().clear();

        try {
            /*Get all customers*/
            ArrayList<CustomerDTO>  allCustomers = customerBO.getAll();
            for (CustomerDTO c : allCustomers) {
                tblCustomers.getItems().add(new CustomerTM(c.getId(), c.getName(), c.getTel(), c.getAddress()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

   /* private ArrayList<CustomerDTO> getAllCustomers() {
        ArrayList<CustomerDTO> customerList = null;
        try {
            customerList = customerBO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }*/

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String tel = txtContact.getText();
        String address = txtAddress.getText();


//        CustomerDTO customer = new CustomerDTO(id, name, tel,address);

        //if (isValid()) {
        try {
            boolean isSaved = customerBO.save(new CustomerDTO(id,name,tel,address));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                initialize();
            }
//                customerBO.save(new CustomerDTO(id,name,tel,address));
//                tblCustomers.getItems().add(new CustomerTM(id, name,tel, address));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //}*/
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
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();

        try {
            boolean isDeleted = customerBO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
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
        String address = txtAddress.getText();


//        CustomerDTO dto  = new CustomerDTO(id, name, tel,address);

        try {

            boolean isUpdated = customerBO.update(new CustomerDTO(id ,name,tel,address ));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
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
            Customer customer = customerBO.searchById(id);

            if (customer != null) {
                txtId.setText(customer.getId());
                txtName.setText(customer.getName());
                txtContact.setText(customer.getTel());
                txtAddress.setText(customer.getAddress());

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void txtCustomerIDOnKeyReleased(KeyEvent keyEvent) {
        //Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ID,txtId);
    }

  /*  public boolean isValid(){
        if (!Regex.setTextColor(TextField.ID,txtId)) return false;
        if (!Regex.setTextColor(TextField.CONTACT,txtContact)) return false;
        if (!Regex.setTextColor(TextField.NAME,txtName)) return false;
        if (!Regex.setTextColor(TextField.ADDRESS,txtAddress)) return false;

        return true;
    }*/

    public void txtCustomerContactOnKeyReleased(KeyEvent keyEvent) {
        //  Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.CONTACT, txtContact);
    }

    public void txtCustomerNameOnKeyReleased(KeyEvent keyEvent) {
        // Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.NAME, txtName);
    }

    public void txtCustomerAddressOnKeyReleased(KeyEvent keyEvent) {
        //   Regex.setTextColor(lk.ijse.citroessentional.Util.TextField.ADDRESS,txtAddress);
    }
}

