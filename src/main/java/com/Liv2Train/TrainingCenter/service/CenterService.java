package com.Liv2Train.TrainingCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Liv2Train.TrainingCenter.entity.Center;
import com.Liv2Train.TrainingCenter.repository.CenterRepository;


@Service
public class CenterService {

	@Autowired
	public CenterRepository repository;
	
	public Center saveCenter(Center center) {
		return repository.save(center);	
	}
		
	public List<Center> getCenters() {
        return repository.findAll();
    }
	
	public Center getCenterById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Center getCenterByCode(String centerCode) {
        return repository.findBycenterCode(centerCode);
    }
}
