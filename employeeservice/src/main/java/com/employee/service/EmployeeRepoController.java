package com.employee.service;

import com.employee.model.Employee;
import com.employee.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeRepoController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/jpa/employees")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @PostMapping("/jpa/employees")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee emp){
        Employee newEmployee = employeeRepository.save(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{employeeId}")
                .buildAndExpand(newEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
