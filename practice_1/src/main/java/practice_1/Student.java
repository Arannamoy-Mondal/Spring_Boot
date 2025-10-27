package practice_1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Student {
    @Id
    public int id;
    public String name;
    public int age;
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Laptop> Laptop;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public List<Laptop> getLaptop() {
        return Laptop;
    }
    public void setLaptop(List<Laptop> laptop) {
        Laptop = laptop;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", Laptop=" + Laptop + "]";
    }

    
}
