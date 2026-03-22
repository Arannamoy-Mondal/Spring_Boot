package com.aranna.practice_9_cardinality;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.ToString;

public class Model {

}


// @Builder
// class Engine{
//     public String vendorName;
//     @OneToMany(fetch = FetchType.EAGER,mappedBy = "engine")
//     @ToString.Exclude
//     @JsonBackReference
//     public List<Vehicle>vehicles;
// }

// @Builder
// class RegistrationNo{
//     public Integer regiNo;
//     @OneToOne(mappedBy = "regiNo")
//     @JsonBackReference
//     public Vehicle vehile;
// }


// @Builder
// class Wheel{

//     public String vendorName;
//     @ManyToMany(mappedBy = "wheels")
//     @ToString.Exclude
//     @JsonBackReference
//     public List<Vehicle> vehicles;
// }




// @Builder
// class SparkPlug{
//     public String vendorName;

//     @ManyToMany(mappedBy = "sparkPlugs")
//     public List<Vehicle> vehicles;
// }


// @Builder
// class Vehicle {

//     @ManyToOne(fetch = FetchType.EAGER)
//     @JoinColumn(name = "engine_id")
//     @JsonManagedReference
//     public Engine engine;

//     @OneToOne
//     @JoinColumn(name = "registration_id")
//     @JsonManagedReference
//     public RegistrationNo registrationNo;

//     @ManyToMany(fetch = FetchType.EAGER)
//     @JoinTable(name="vehicle_wheel",
//         joinColumns = @JoinColumn(name="vehicle_id"),
//         inverseJoinColumns = @JoinColumn(name="wheel_id")
//     )
//     @JsonManagedReference
//     public List<Wheel> wheels;
// }


