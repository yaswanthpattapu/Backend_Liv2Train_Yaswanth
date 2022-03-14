package com.Liv2Train.TrainingCenter.entity;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "center")
public class Center{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
	@NotBlank
	@Size(max=40, message="CenterName should have atmost 40 characters")
	public String centerName;
	
	@Pattern(regexp="(^[a-zA-Z0-9]{12})",message="CenterCode should have exactly 12 characters and Alphanumeric")
	public String centerCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	public Address address;
	
	public int capacity;
	
	public ArrayList<String> coursesOffered;
	
	public Timestamp createdOn;
	
	@Email
	public String contactEmail;
	@Pattern(regexp="(^[1-9][0-9]{9})",message="Phone number should have exactly 10 digits")
	public String contactPhone;
	
		
	
	
}
