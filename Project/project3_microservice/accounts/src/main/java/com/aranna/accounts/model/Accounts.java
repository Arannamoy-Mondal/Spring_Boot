package com.aranna.accounts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseModel {
    private Long customerId;
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer accountNumber;
    private String accountType;
    private String branchAddress;
}
