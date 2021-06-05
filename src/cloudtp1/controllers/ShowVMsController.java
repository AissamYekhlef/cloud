/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.controllers;

import cloudtp1.util.MyCloudsimAssistantUtil;
import cloudtp1.util.MyVM;
import cloudtp1.util.MyVMList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Vm;

/**
 * FXML Controller class
 *
 * @author IssamYayou
 */
public class ShowVMsController implements Initializable {

    ObservableList<Vm> list = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Vm> table_vms;
    
    @FXML
    private TableColumn<Vm, Integer> vmidCol;
    @FXML
    private TableColumn<Vm, Integer> mipsCol;
    @FXML
    private TableColumn<Vm, Long> sizeCol;
    @FXML
    private TableColumn<Vm, Long> bwCol;
    @FXML
    private TableColumn<Vm, Integer> ramCol;
    @FXML
    private TableColumn<Vm, String> vmmCol;
    @FXML
    private TableColumn<Vm, Integer> pesNumberCol;
//    @FXML
//    private TableColumn<Vm, String> cloudletSchedulerCol;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initTable();
        loadData();

    }  
    
    private void initTable(){
        vmidCol.setCellValueFactory(new PropertyValueFactory<>("id"));     
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));       
        mipsCol.setCellValueFactory(new PropertyValueFactory<>("mips"));  
        pesNumberCol.setCellValueFactory(new PropertyValueFactory<>("numberOfPes"));      
        ramCol.setCellValueFactory(new PropertyValueFactory<>("ram"));     
        bwCol.setCellValueFactory(new PropertyValueFactory<>("bw"));       
        vmmCol.setCellValueFactory(new PropertyValueFactory<>("vmm"));      
//        cloudletSchedulerCol.setCellValueFactory(new PropertyValueFactory<>("vmm"));

//        table_vms.setEditable(true);

    }
    private void loadData(){
        for (Vm vm : MyVMList.get()){
            list.add(vm); 
        }
        table_vms.setItems( list );

    }
    

}
    
