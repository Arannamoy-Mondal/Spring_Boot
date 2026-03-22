package com.aranna.practice_9_cardinality.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aranna.practice_9_cardinality.model.RegistrationNo;
@Repository
public interface RegistrationNoRepo extends JpaRepository<RegistrationNo,Integer>{

}
