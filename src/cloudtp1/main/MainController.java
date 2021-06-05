/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.main;

import cloudtp1.util.MyCloudsimAssistantUtil;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author IssamYayou
 */
public class MainController implements Initializable{

    
    @FXML
    private Button add_datacenter;
    @FXML
    private Button cancelButton;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        init
    }
    
    @FXML
    public void addDataCenter(ActionEvent evnt){
        MyCloudsimAssistantUtil.loadWindow(getClass().getResource("/cloudtp1/fxml/add_datacenter.fxml"), "Add Datacenter", null);
        System.out.println("Add Datacenter button");
    }
    
    @FXML
    public void addVM(ActionEvent evnt){
        MyCloudsimAssistantUtil.loadWindow(getClass().getResource("/cloudtp1/fxml/add_vm.fxml"), "Add New Virtual Machine (VM)", null);
        System.out.println("Add Datacenter button");
    }
    
    @FXML
    public void showSim(){
        MyCloudsimAssistantUtil.loadWindow(
                getClass().getResource("/cloudtp1/fxml/show_details.fxml"), "Show Simulation", null);
    }
    
    
}
