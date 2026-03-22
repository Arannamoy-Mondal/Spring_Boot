package com.aranna.practice_9_cardinality.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aranna.practice_9_cardinality.model.Wheel;
@Repository
public interface WheelRepo extends JpaRepository<Wheel,Integer>{

}
