package com.example.crud.repository;

import com.example.crud.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<employee, Long> {
//all crud methods

}
