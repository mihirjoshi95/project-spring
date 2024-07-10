package com.boa.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
public class Student extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(cascade =CascadeType.ALL )
	private List<Course> courses;
	private String address;
	private String grade;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id", referencedColumnName = "id")
	private Payment payment;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	

}
