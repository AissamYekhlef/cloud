/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.util;

import org.cloudbus.cloudsim.DatacenterBroker;

/**
 *
 * @author IssamYayou
 */
public class MyDCBroker {
    
    private static DatacenterBroker broker = null;
    
    public static DatacenterBroker create(String name){
        
        if(broker == null){
            try {
                broker = new DatacenterBroker(name); 
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        
        return broker;
    }
    
    public static DatacenterBroker get(){       
        return broker;
    }
    
    
            
    
}
