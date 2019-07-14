package com.person.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Person {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private Long personId;
	private String firstName;
	private String lastName;
	private int age;
	private String aimOfLife;
	private String address;
	private long bankBalance;
}
