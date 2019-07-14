package com.student.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.student.dto.Address;

import lombok.Data;
@Data
@Table
@Entity
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2491904705287574443L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	private String firstName;
	private String lastName;
//	private Address address;
	private int age;
	private String rollNo;
	private float percentage;
	private String aimOfLife;
	private String hobbies;

	private LocalDateTime registerStamp=LocalDateTime.now();
}
