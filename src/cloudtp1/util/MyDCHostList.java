/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.util;

import java.util.ArrayList;
import java.util.List;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.lists.HostList;

/**
 *
 * @author IssamYayou
 */
public class MyDCHostList extends HostList{
    
    public static List<Host> hostList = new ArrayList<Host>();
    
    private MyDCHostList(){
        
    }
    
    public static void add(Host host){
        hostList.add(host);             
    }
    
    public static List<Host> get(){
        return hostList;
    }
    
    public static Host getById (int id){
        return getById( MyDCHostList.hostList, id);     
    }

    public static int getNumberOfPes (){    
      return getNumberOfPes( MyDCHostList.hostList);
    }
    
}
