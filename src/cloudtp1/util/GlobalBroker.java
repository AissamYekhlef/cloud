/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.util;

import java.util.LinkedList;
import java.util.List;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.core.SimEntity;
import org.cloudbus.cloudsim.core.SimEvent;

/**
 *
 * @author IssamYayou
 */

public class GlobalBroker extends SimEntity {

    private static final int CREATE_BROKER = 0;
    private List<Vm> vmList;
    private List<Cloudlet> cloudletList;
    private DatacenterBroker broker;

    public GlobalBroker(String name) {
            super(name);
    }

    @Override
    public void processEvent(SimEvent ev) {
        switch (ev.getTag()) {
        case CREATE_BROKER:
                setBroker(createBroker(super.getName()+"_"));

                //Create VMs and Cloudlets and send them to broker
                setVmList(MyVMList.get()); //creating 5 vms
                setCloudletList(createCloudlet(getBroker().getId(), 10, 100)); // creating 10 cloudlets

                broker.submitVmList(getVmList());
                broker.submitCloudletList(getCloudletList());

                CloudSim.resumeSimulation();

                break;

        default:
                Log.printLine(getName() + ": unknown event type");
                break;
        }
    }

    @Override
    public void startEntity() {
        Log.printLine(super.getName()+" is starting...");
        schedule(getId(), 200, CREATE_BROKER);
    }

    @Override
    public void shutdownEntity() {
    }

    public List<Vm> getVmList() {
        return vmList;
    }

    protected void setVmList(List<Vm> vmList) {
        this.vmList = vmList;
    }

    public List<Cloudlet> getCloudletList() {
        return cloudletList;
    }

    protected void setCloudletList(List<Cloudlet> cloudletList) {
        this.cloudletList = cloudletList;
    }

    public DatacenterBroker getBroker() {
        return broker;
    }

    protected void setBroker(DatacenterBroker broker) {
        this.broker = broker;
    }

        private static DatacenterBroker createBroker(String name){

    DatacenterBroker broker = null;
    try {
        broker = new DatacenterBroker(name);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    return broker;
    }
    private static List<Cloudlet> createCloudlet(int userId, int cloudlets, int idShift){
        // Creates a container to store Cloudlets
        LinkedList<Cloudlet> list = new LinkedList<Cloudlet>();

        //cloudlet parameters
        long length = 40000;
        long fileSize = 300;
        long outputSize = 300;
        int pesNumber = 1;
        UtilizationModel utilizationModel = new UtilizationModelFull();

        Cloudlet[] cloudlet = new Cloudlet[cloudlets];

        for(int i=0;i<cloudlets;i++){
            cloudlet[i] = new Cloudlet(idShift + i, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
            // setting the owner of these Cloudlets
            cloudlet[i].setUserId(userId);
            list.add(cloudlet[i]);
        }

        return list;
    }

}