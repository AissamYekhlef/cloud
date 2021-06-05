/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.controllers;

import cloudtp1.util.MyCloudsimAssistantUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author IssamYayou
 */
public class ShowDetailsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void showVMs(ActionEvent event){
        System.out.println("Show All Vms Table");
        MyCloudsimAssistantUtil.loadWindow(getClass().getResource("/cloudtp1/fxml/show_vms.fxml"), "Show VMs Table", null);
    }
    @FXML
    public void showHosts(ActionEvent event){
        System.out.println("Show All Hosts Table");
        MyCloudsimAssistantUtil.loadWindow(getClass().getResource("/cloudtp1/fxml/show_hosts.fxml"), "Show Datacenter Hosts Table", null);
    }
    @FXML
    public void showCloudlets(ActionEvent event){
        System.out.println("Show Cloudlets Table");
        MyCloudsimAssistantUtil.loadWindow(getClass().getResource("/cloudtp1/fxml/show_cloudlets.fxml"), "Show Cloudlets Table", null);
    }
    @FXML
    public void showDCC(ActionEvent event){
        System.out.println("Show DCC Table");
//        MyCloudsimAssistantUtil.loadWindow(getClass().getResource("/cloudtp1/fxml/show_cloudlets.fxml"), "Show Cloudlets Table", null);
    
     }
    
    @FXML
    public void startSim(ActionEvent event){
        System.out.println("Start Cloudsim Simulatoin");
        MyCloudsimAssistantUtil.loadWindow(getClass().getResource("/cloudtp1/fxml/show_simulation.fxml"), "Show Cloudlets Table", null);
    }
    
    
    
}
