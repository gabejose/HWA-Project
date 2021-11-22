package com.qa.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.BoatClub;

@Repository
public interface BoatClubRepo extends JpaRepository<BoatClub, Long>{

}
