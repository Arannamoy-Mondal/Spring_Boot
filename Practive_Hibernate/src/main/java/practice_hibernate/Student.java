package practice_hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Student_table")
public class Student {
    @Id
    private int roll;

    @Column(name="std_name")
    private String name;
    private int age;
    @OneToOne
    private Laptop laptop;
    // @ManyToOne
    // private List<Laptop> laptops;

    
    public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    // public List<Laptop> getLaptops() {
    //     return laptops;
    // }
    // public void setLaptops(List<Laptop> laptops) {
    //     this.laptops = laptops;
    // }
    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [roll=" + roll + ", name=" + name + ", age=" + age + "]";
    }
    
}
