/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;

/**
 *
 * @author IssamYayou
 */
public class MyCloudletList {
     public static int last_id = 1;
    public static List<Cloudlet> clList = new ArrayList<>();
    
    private MyCloudletList(){
        
    }
    
    public static void add(Cloudlet cl){
        clList.add(cl);
        last_id++;   
    }
    
    public static List<Cloudlet> get(){
        return clList;
    }
    
    
    public static List<Cloudlet> createList(int userId, int cloudlets){

        //cloudlet parameters
        long length = 40000;
        long fileSize = 300;
        long outputSize = 300;
        int pesNumber = 1;
        UtilizationModel utilizationModel = new UtilizationModelFull();

        Cloudlet[] cloudlet = new Cloudlet[cloudlets];

        for(int i=0;i<cloudlets;i++){
            cloudlet[i] = new Cloudlet(last_id + i, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
            // setting the owner of these Cloudlets
            cloudlet[i].setUserId(userId);
            clList.add(cloudlet[i]);
        }
        
        return clList;
    }
    
    
}
