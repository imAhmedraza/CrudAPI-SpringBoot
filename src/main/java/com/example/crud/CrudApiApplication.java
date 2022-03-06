package com.example.crud;

import com.example.crud.model.employee;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	//sample data for postman/database
	@Override
	public void run(String... args) throws Exception {

		employee employee = new employee();
		employee.setFirstName("Ahmed");
		employee.setLastName("Raza");
		employee.setEmailId("ahmed@raza.com");
		employeeRepository.save(employee);

		employee employee1 = new employee();
		employee1.setFirstName("Salman");
		employee1.setLastName("Raza");
		employee1.setEmailId("salman@raza.com");
		employeeRepository.save(employee1);


	}
}
