package com.Liv2Train.TrainingCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Liv2Train.TrainingCenter.entity.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center,Integer>{

	Center findBycenterCode(String centerCode);


}
