package com.aranna.java13_spring_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aranna.java13_spring_jpa.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle,Integer>{

}
