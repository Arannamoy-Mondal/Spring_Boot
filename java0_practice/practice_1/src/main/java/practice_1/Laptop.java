package practice_1;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Cacheable
public class Laptop {
    @Id
    public int id;
    public String cpu;
    public String ssd;
    public int ram;
    
    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public String getSsd() {
        return ssd;
    }
    public void setSsd(String ssd) {
        this.ssd = ssd;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    @Override
    public String toString() {
        return "Laptop [cpu=" + cpu + ", ssd=" + ssd + ", ram=" + ram + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
