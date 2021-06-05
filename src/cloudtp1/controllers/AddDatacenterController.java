package cloudtp1.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import cloudtp1.util.MyDCHostList;
import cloudtp1.util.MyDataCenter;


public class AddDatacenterController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField id;
//    @FXML
//    private JFXTextField author;
//    @FXML
//    private JFXTextField publisher;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton cancelButton;

//    DatabaseHandler databaseHandler;
    @FXML
    private AnchorPane rootPane;
    private Boolean isInEditMode = Boolean.FALSE;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        databaseHandler = DatabaseHandler.getInstance();
    }

    @FXML
    private void addDatacenter(ActionEvent event) {
        String bookID = id.getText();
//        String bookAuthor = author.getText();
        String dc_name = name.getText();
        
        
        String arch = "x86"; // system architecture
        String os = "Linux"; // operating system
        String vmm = "Xen";
        double time_zone = 10.0; // time zone this resource located
        double cost = 3.0; // the cost of using processing in this resource
        double costPerMem = 0.05; // the cost of using memory in this resource
        double costPerStorage = 0.001; // the cost of using storage in this
                                                                        // resource
        double costPerBw = 0.0; // the cost of using bw in this resource
        LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are not adding SAN
        List hostList = MyDCHostList.get();    // devices by now
        
        DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
                        arch, os, vmm, hostList, time_zone, cost, costPerMem,
                        costPerStorage, costPerBw);

        // 6. Finally, we need to create a PowerDatacenter object.
        Datacenter datacenter = null;
        try {
                datacenter = new Datacenter(dc_name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        MyDataCenter.set(datacenter);
        
//        String bookPublisher = publisher.getText();
//
//        if (bookID.isEmpty() || bookAuthor.isEmpty() || bookName.isEmpty() || bookPublisher.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("Please Enter in all fields");
//            alert.showAndWait();
//            return;
//        }
//
//        if (isInEditMode) {
//            handleEditOperation();
//            return;
//        }

//        if (databaseHandler.execAction(qu)) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText(null);
//            alert.setContentText("Success");
//            alert.showAndWait();        
//            Stage stage = (Stage) rootPane.getScene().getWindow();
//            stage.close();
//        } else //Error
//        {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("Failed");
//            alert.showAndWait();
//        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    private void checkData() {
//        String qu = "SELECT title FROM BOOK";
//        ResultSet rs = databaseHandler.execQuery(qu);
//        try {
//            while (rs.next()) {
//                String titlex = rs.getString("title");
//                System.out.println(titlex);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BookAddController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
//
//    public void inflateUI(BookListController.Book book) {
//        title.setText(book.getTitle());
//        id.setText(book.getId());
//        author.setText(book.getAuthor());
//        publisher.setText(book.getPublisher());
//        id.setEditable(false);
//        isInEditMode = Boolean.TRUE;
//    }
//
//    private void handleEditOperation() {
//        BookListController.Book book = new BookListController.Book(title.getText(), id.getText(), author.getText(), publisher.getText(), true);
//        if (databaseHandler.updateBook(book)) {
//            AlertMaker.showSimpleAlert("Success", "Book Updated");
//        } else {
//            AlertMaker.showErrorMessage("Failed", "Cant update book");
//        }
//    }
}
