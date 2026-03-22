package com.aranna.practice_9_cardinality.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;


    @OneToOne
    @JoinColumn(name = "registration_no")
    private RegistrationNo registrationNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="engine_id")
    private Engine engine;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="vehicle_wheel",
        joinColumns = @JoinColumn(name="vehicle_id"),
        inverseJoinColumns = @JoinColumn(name="wheel_id")
    )
    private List<Wheel> wheels; 
}
