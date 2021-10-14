package net.javaguides.springboot.repository;
//package com.mindtree.employeemanagerapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeeRepositoryTest {
	
	
	@Autowired
	 EmployeeRepository employeeRepository;
	
	@Test
	@Order(1)
	public void employeeCreate () {
		Employee employee = new Employee();
//		employee.setId(100L);
		employee.setFirstName("rahul");
		employee.setLastName("jain");
		employee.setEmailId("rahul@gmail.com");
		employeeRepository.save(employee);
		assertNotNull(employeeRepository.findByfirstname("rahul"));
	}
		
	@Test
	@Order(2)
	public void getAllEmployees () {
		List<Employee> list = employeeRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void getEmployee () {
		Employee employee = employeeRepository.findById(1L).get();
		assertEquals("rakshit", employee.getFirstName());
	}
		
	@Test
	@Order(4)
	public void employeeUpdate () {
		Employee employee = employeeRepository.findByfirstname("rahul");
		employee.setFirstName("rajesh");
		employeeRepository.save(employee);
		assertNotEquals("rajesh@gmail.com", employeeRepository.findByfirstname("rajesh").getEmailId());
	}
		
	@Test
	@Order(5)
	public void testDelete () {
		employeeRepository.deleteByfirstName("rahul");;
		assertThat(employeeRepository.existsById(3L)).isTrue();
	}

}