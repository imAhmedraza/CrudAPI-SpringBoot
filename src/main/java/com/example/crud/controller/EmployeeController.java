package com.example.crud.controller;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.employee;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create employee API
    @PostMapping
    public employee createEmployee(@RequestBody employee employee){
        return employeeRepository.save(employee);
    }

    //get employee by Id API
    @GetMapping("{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable long id){

        employee employee =employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("employee not exist with this Id: " + id));
        return ResponseEntity.ok(employee);
    }

    //Update employee API
    @PutMapping("{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable long id,@RequestBody employee employeeData){

        employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:" + id));
        updateEmployee.setFirstName(employeeData.getFirstName());
        updateEmployee.setLastName(employeeData.getLastName());
        updateEmployee.setEmailId(employeeData.getEmailId());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //Delete Employee API
    @DeleteMapping("{id}")
    private ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        employee deleteEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:" + id));
        employeeRepository.delete(deleteEmployee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
