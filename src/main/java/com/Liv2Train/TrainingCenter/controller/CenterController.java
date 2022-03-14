package com.Liv2Train.TrainingCenter.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Liv2Train.TrainingCenter.entity.Center;
import com.Liv2Train.TrainingCenter.service.CenterService;


@RestController
public class CenterController {
	@Autowired
	public CenterService service;
	
	@PostMapping("/addcenter")
	@ResponseBody
	public ResponseEntity<Center> addCenter(@Valid @RequestBody Center center) {
		center.createdOn = new Timestamp(System.currentTimeMillis());
		Center savedCenter = service.saveCenter(center);
		return new ResponseEntity<Center>(savedCenter, HttpStatus.CREATED);
	}
	
	@GetMapping("/allcenters")
	public List<Center> findAllCenters() {
        return service.getCenters();
    }
	
	@GetMapping("/centerbyid/{id}")
    public Center findProductById(@PathVariable int id) {
        return service.getCenterById(id);
    }

    @GetMapping("/centerbycode/{centerCode}")
    public Center findProductByName(@PathVariable String centerCode) {
        return service.getCenterByCode(centerCode);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}
