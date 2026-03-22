package com.aranna.practice_9_cardinality.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class RegistrationNo {

    @Id
    private Integer resgistrationNo;

    @OneToOne(mappedBy = "registrationNo")
    @JsonBackReference
    @ToString.Exclude
    private Vehicle vehicle;
}
