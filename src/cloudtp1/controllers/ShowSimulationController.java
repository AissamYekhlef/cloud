/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.controllers;

import cloudtp1.util.GlobalBroker;
import cloudtp1.util.MyCloudletList;
import cloudtp1.util.MyDCBroker;
import cloudtp1.util.MyDataCenter;
import cloudtp1.util.MyVMList;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

/**
 * FXML Controller class
 *
 * @author IssamYayou
 */
public class ShowSimulationController implements Initializable {

    @FXML
    private TextArea text_result;
    
    /** The cloudlet list. */
    private static List<Cloudlet> cloudletList;

    /** The vmList. */
    private static List<Vm> vmList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String result = "";
        result = print_simulation_result();
        
        text_result.setText(result);     
    }    
    
    public String print_simulation_result(){
        
        String  result = "";
        
        result += "Starting CloudSim Simulation...";

        try {
                // First step: Initialize the CloudSim package. It should be called
                // before creating any entities.
                int num_user = 2;   // number of grid users
                Calendar calendar = Calendar.getInstance();
                boolean trace_flag = false;  // mean trace events

                // Initialize the CloudSim library
                CloudSim.init(num_user, calendar, trace_flag);

                GlobalBroker globalBroker = new GlobalBroker("GlobalBroker");

                // Second step: Create Datacenters
                //Datacenters are the resource providers in CloudSim. We need at list one of them to run a CloudSim simulation
                @SuppressWarnings("unused")
                Datacenter datacenter0 = createDatacenter("Datacenter00");

                //Third step: Create Broker
                DatacenterBroker broker = MyDCBroker.create("Broker_0");
                int brokerId = broker.getId();

                //Fourth step: Create VMs and Cloudlets and send them to broker
                vmList = MyVMList.get(); //creating 5 vms
                cloudletList = MyCloudletList.createList(brokerId, 10); // creating 10 cloudlets

                broker.submitVmList(vmList);
                broker.submitCloudletList(cloudletList);

                // Fifth step: Starts the simulation
                CloudSim.startSimulation();

                // Final step: Print results when simulation is over
                List<Cloudlet> newList = broker.getCloudletReceivedList();
                newList.addAll(globalBroker.getBroker().getCloudletReceivedList());

                CloudSim.stopSimulation();

                result += printCloudletList(newList);

                result += " \n CloudSim Simulation finished!";
        }
        catch (Exception e)
        {
                e.printStackTrace();
                Log.printLine("The simulation has been terminated due to an unexpected error");
        }
        
        return result;
    }
    
    private static String printCloudletList(List<Cloudlet> list) {
        
        String result = "";
		int size = list.size();
		Cloudlet cloudlet;

		String indent = "    ";
		Log.printLine();
                result += "\n";
                
		result += "========== OUTPUT ==========";
		result += "Cloudlet ID" + indent + "STATUS" + indent +
				"Data center ID" + indent + "VM ID" + indent + indent + "Time" + indent + "Start Time" + indent + "Finish Time";

		DecimalFormat dft = new DecimalFormat("###.##");
		for (int i = 0; i < size; i++) {
			cloudlet = list.get(i);
			result += indent + cloudlet.getCloudletId() + indent + indent;

			if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS){
				result += "SUCCESS";

				result += indent + indent + cloudlet.getResourceId() + indent + indent + indent + cloudlet.getVmId() +
						indent + indent + indent + dft.format(cloudlet.getActualCPUTime()) +
						indent + indent + dft.format(cloudlet.getExecStartTime())+ indent + indent + indent + dft.format(cloudlet.getFinishTime());
			}
		}
            return result;
	}
    
    private static Datacenter createDatacenter(String name) {

        // Here are the steps needed to create a PowerDatacenter:
        // 1. We need to create a list to store
        // our machine
        List<Host> hostList = new ArrayList<Host>();

        // 2. A Machine contains one or more PEs or CPUs/Cores.
        // In this example, it will have only one core.
        List<Pe> peList = new ArrayList<Pe>();

        int mips = 1000;

        // 3. Create PEs and add these into a list.
        peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store Pe id and MIPS Rating

        // 4. Create Host with its id and list of PEs and add them to the list
        // of machines
        int hostId = 0;
        int ram = 2048; // host memory (MB)
        long storage = 1000000; // host storage
        int bw = 10000;

        hostList.add(
                new Host(
                        hostId,
                        new RamProvisionerSimple(ram),
                        new BwProvisionerSimple(bw),
                        storage,
                        peList,
                        new VmSchedulerTimeShared(peList)
                )
        ); // This is our machine

        // 5. Create a DatacenterCharacteristics object that stores the
        // properties of a data center: architecture, OS, list of
        // Machines, allocation policy: time- or space-shared, time zone
        // and its price (G$/Pe time unit).
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
                                                                                                // devices by now

        DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
                        arch, os, vmm, hostList, time_zone, cost, costPerMem,
                        costPerStorage, costPerBw);

        // 6. Finally, we need to create a PowerDatacenter object.
        Datacenter datacenter = null;
        try {
                datacenter = new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
        } catch (Exception e) {
                e.printStackTrace();
        }

        return datacenter;
	}
    
}
