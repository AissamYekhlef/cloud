/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.controllers;

import cloudtp1.util.MyCloudletList;
import cloudtp1.util.MyDCHostList;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.provisioners.BwProvisioner;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisioner;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

/**
 * FXML Controller class
 *
 * @author IssamYayou
 */
public class ShowHostsController implements Initializable {

   ObservableList<Host> list = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Host> table_hosts;
    
    @FXML
    private TableColumn<Cloudlet, Integer> idCol;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        loadData();  
    }    
    
    private void initTable(){
        // TODO init Cols
    }
    
    private void loadData(){
        list.addAll(MyDCHostList.get());
        
        List<Pe> peList = new ArrayList<Pe>();

	int mips = 1000;
        peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store Pe id and MIPS Rating

        // 4. Create Host with its id and list of PEs and add them to the list
        // of machines
        int hostId = 0;
        int ram = 2048; // host memory (MB)
        long storage = 1000000; // host storage
        int bw = 10000;

        list.add(
                new Host(
                        hostId,
                        new RamProvisionerSimple(ram),
                        new BwProvisionerSimple(bw),
                        storage,
                        peList,
                        new VmSchedulerTimeShared(peList)
                ));

        table_hosts.setItems( list );     
    }
    
    
}
