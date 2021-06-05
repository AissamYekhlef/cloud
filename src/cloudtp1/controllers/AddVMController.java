package cloudtp1.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Vm;
import cloudtp1.util.MyVMList;


public class AddVMController implements Initializable {

    @FXML
    private JFXTextField vmid;
    @FXML
    private JFXTextField mips;
    @FXML
    private JFXTextField size;
    @FXML
    private JFXTextField ram;
    @FXML
    private JFXTextField bw;
    @FXML
    private JFXTextField pesNumber;
    @FXML
    private JFXTextField vmm;

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
    vmid.setText( MyVMList.last_id +"");
    
    }

    @FXML
    private void addVM(ActionEvent event) {
        
//
        if (    vmid.getText().isEmpty() || 
                mips.getText().isEmpty() || 
                size.getText().isEmpty() ||
                bw.getText().isEmpty()   ||
                size.getText().isEmpty() || 
                ram.getText().isEmpty()  || 
                vmm.getText().isEmpty()  || 
                pesNumber.getText().isEmpty()
            ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter in all fields");
            alert.showAndWait();
            return;
        }else{
            
            int vmid_ = Integer.valueOf( vmid.getText() );
            int mips_ = Integer.valueOf( mips.getText() );
            long size_ = Long.valueOf( size.getText() );
            int ram_ = Integer.valueOf( ram.getText() );
            long bw_ = Long.valueOf( bw.getText() );
            int pesNumber_ = Integer.valueOf( pesNumber.getText() );
            String vmm_ = vmm.getText();

            int brokerId = 1;

            Vm vm = new Vm(vmid_, brokerId, mips_, pesNumber_, ram_, bw_, size_, vmm_, new CloudletSchedulerTimeShared());

            System.out.println("VM caracteristics : " +  
                   "\n " + " VM ID "+ vm.getId()+
                   "\n " + " VM MIPS "+ vm.getMips()+
                   "\n " + " VM Size "+ vm.getSize()+
                   "\n " + " VM Ram "+ vm.getRam()+
                   "\n " + " VM Bandwidth "+ vm.getBw()+
                   "\n " + " VM Pes Number "+ vm.getNumberOfPes()+
                   "\n " + " VM VMM name "+ vm.getVmm()
            );

            MyVMList.add(vm);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Success");
            alert.showAndWait();        
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
        }
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
