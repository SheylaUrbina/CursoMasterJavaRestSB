package com.employee.service;

import com.employee.exception_handler.EmployeeNotFound;
import com.employee.model.Department;
import com.employee.model.DepartmentRepository;
import com.employee.model.Employee;
import com.employee.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeRepoController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/jpa/employees")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/jpa/departments")
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }


    @GetMapping("/jpa/employees/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId){
        Employee employee = employeeRepository.findById(empId).get();
        System.out.println("Empleado: "+employee.getId()+" "+employee.getName()+" "+employee.getAllDepartments().get(0).getDepartment());
        if(null == employee)
            throw new EmployeeNotFound("Employee Not Found .");

        return employee;
    }

    //este es con hateoas - no muestra toda la informacion del empleado
    @GetMapping("/jpa/employeesModel/{empId}")
    public EntityModel<Employee> getEmployeeByIdModel(@PathVariable Long empId){
        Employee employee = employeeRepository.findById(empId).get();
        System.out.println("Empleado: "+employee.getId()+" "+employee.getName()+" "+employee.getAllDepartments().get(0).getDepartment());
        if(null == employee)
            throw new EmployeeNotFound("Employee Not Found .");
        EntityModel<Employee> model = EntityModel.of(employee);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll()).withRel("all-employees");
        model.add(link);

        return model;
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

    @PostMapping("/jpa/adddepartment/{empId}")
    public ResponseEntity<Object> saveEmployee(@PathVariable Long empId, @RequestBody Department department){
        Employee employee = employeeRepository.findById(empId).get();
        System.out.println("Empleado: "+employee.getId()+" "+employee.getName());
        if(null == employee)
            throw new EmployeeNotFound("Employee Not Found .");

        department.setEmployee(employee);
        departmentRepository.save(department);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{empId}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("jpa/employee/delete/{empId}")
    public void deleteEmployee(@PathVariable Long empId){
        Employee emp = employeeRepository.findById(empId).get();
        if(null == emp)
            throw new EmployeeNotFound("Employee Not Found .");

        employeeRepository.delete(emp);
    }

}
