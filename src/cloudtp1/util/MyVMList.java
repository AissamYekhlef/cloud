/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.util;

import java.util.ArrayList;
import java.util.List;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Vm;

/**
 *
 * @author IssamYayou
 */
public class MyVMList {
    
    
    public static int last_id = 1;
    public static List<Vm> vmList = new ArrayList<Vm>();
    
    private MyVMList(){
        
    }
    
    public static void add(Vm vm){
        vmList.add(vm);
        last_id++;   
    }
    
    public static List<Vm> get(){
        return vmList;
    }
    
}
