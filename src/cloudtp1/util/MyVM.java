/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudtp1.util;


/**
 *
 * @author IssamYayou
 */
public class MyVM {
    
        private final int id;
        private final long size;
        private final int mips;
        private final int ram;
        private final int pesNumber;
        private final long bw;
        private final String vmm;

    public MyVM(int id, long size, int mips, int ram, int pesNumber, long bw, String vmm) {
        this.id = id;
        this.size = size;
        this.mips = mips;
        this.ram = ram;
        this.pesNumber = pesNumber;
        this.bw = bw;
        this.vmm = vmm;
    }

    public int getId() {
        return id;
    }

    public long getSize() {
        return size;
    }

    public int getMips() {
        return mips;
    }

    public int getRam() {
        return ram;
    }

    public int getPesNumber() {
        return pesNumber;
    }

    public long getBw() {
        return bw;
    }

    public String getVmm() {
        return vmm;
    }
        
    
}
