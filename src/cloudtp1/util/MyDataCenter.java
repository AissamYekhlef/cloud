/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.util;

import org.cloudbus.cloudsim.Datacenter;

/**
 *
 * @author IssamYayou
 */
public class MyDataCenter {
    
    public static Datacenter datacenter = null;
    
    public static Datacenter get(){
        return  datacenter;      
    }
    
    public static void set(Datacenter dc){
        datacenter = dc;        
    }
    
}
