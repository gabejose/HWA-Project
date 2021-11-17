package com.qa.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.Boat;

@Repository
public interface BoatRepo extends JpaRepository<Boat, Long>{

}
