package com.hibernate.hibernate_concept;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "student")
public class Student {

    @Id
    private int rollNo;
    private String sName;
    private int sAge;

    public int getRollNo() {
        return rollNo;
    }
    public String getsName() {
        return sName;
    }
    public int getsAge() {
        return sAge;
    }
    

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public void setsAge(int sAge) {
        this.sAge = sAge;
    }
    
    public String greet(){
        return "hello students";
    }
    public void console_print(){
        System.out.println("Hello");
    }
    
    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", sName=" + sName + ", sAge=" + sAge + "]";
    }
    
}
