package com.aranna.practice_9_cardinality.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer engineId;
    private String vendorName;
    
    @OneToMany(mappedBy ="engine")
    @ToString.Exclude
    @JsonBackReference
    private List<Vehicle> vehicles;
}
