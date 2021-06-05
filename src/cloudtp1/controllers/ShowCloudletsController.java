/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.controllers;

import cloudtp1.util.MyCloudletList;
import cloudtp1.util.MyVMList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;

/**
 * FXML Controller class
 *
 * @author IssamYayou
 */
public class ShowCloudletsController implements Initializable {

    ObservableList<Cloudlet> list = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Cloudlet> table_cloudlets;
    
    @FXML
    private TableColumn<Cloudlet, Integer> idCol;
    @FXML
    private TableColumn<Cloudlet, Long> lengthCol;
    @FXML
    private TableColumn<Cloudlet, Integer> pesNumberCol;
    @FXML
    private TableColumn<Cloudlet, Long> fileSizeCol;
    @FXML
    private TableColumn<Cloudlet, Long> outputCol;
    @FXML
    private TableColumn<Cloudlet, Double> ramCol;
    @FXML
    private TableColumn<Cloudlet, Double> cpuCol;
    @FXML
    private TableColumn<Cloudlet, Double> bwCol;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadData();  
    }    
    
        private void initTable(){

        idCol.setCellValueFactory(new PropertyValueFactory<>("cloudletId"));
        lengthCol.setCellValueFactory(new PropertyValueFactory<>("cloudletLength"));
        pesNumberCol.setCellValueFactory(new PropertyValueFactory<>("numberOfPes"));
        fileSizeCol.setCellValueFactory(new PropertyValueFactory<>("cloudletFileSize"));
        outputCol.setCellValueFactory(new PropertyValueFactory<>("cloudletOutputSize")); 
        cpuCol.setCellValueFactory(new PropertyValueFactory<>("utilizationModelCpu")); 
        ramCol.setCellValueFactory(new PropertyValueFactory<>("utilizationModelRam")); 
        bwCol.setCellValueFactory(new PropertyValueFactory<>("utilizationModelBw")); 



    }
    private void loadData(){
        for (Cloudlet cl : MyCloudletList.get()){
            list.add(cl); 
        }
        table_cloudlets.setItems( list );     
        table_cloudlets.getItems().addAll(
                new Cloudlet(1, 400000, 1, 300, 300, new UtilizationModelFull() , new UtilizationModelFull(), new UtilizationModelFull()),
                new Cloudlet(2, 600000, 1, 300, 100, new UtilizationModelFull() , new UtilizationModelFull(), new UtilizationModelFull())
        );


    }
    
    
}
