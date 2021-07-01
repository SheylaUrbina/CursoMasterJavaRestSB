package com.employee.service;

import com.employee.exception_handler.EmployeeNotFound;
import com.employee.model.Employee;
import com.employee.model.EmployeeDao;
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
public class EmployeeController {

    @Autowired
    EmployeeDao service;

    @GetMapping("/employees")
    public List<Employee> getAll(){
    return service.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public EntityModel<Employee> getEmployeeById(@PathVariable int empId) {
        //EntityModel add aditional information like link Chapter 56: Implement Hateoas
        Employee employee = service.getEmployeeById(empId);
        if(null == employee)
            throw new EmployeeNotFound("No existe ese código de empleado.");
        EntityModel<Employee> model = EntityModel.of(employee);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll()).withRel("todos-empleados");
        model.add(link);
        return model;
    }

    @PostMapping("/employees/user")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee emp){
        Employee newEmployee = service.saveEmployee(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{employeeId}")
                .buildAndExpand(newEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/employees/delete/{empId}")
    public EntityModel<Employee> deleteEmployee(@PathVariable int empId){
        Employee emp = service.deleteEmployee(empId);
        if(null == emp)
            throw new EmployeeNotFound("No existe ese código de empleado.");
        EntityModel<Employee> model = EntityModel.of(emp);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll()).withRel("Empleado_eliminado-Revisar-Lista");
        model.add(link);
        return model;
    }


    /*    @DeleteMapping("/employees/delete/{empId}")
    public void deleteEmployee(@PathVariable int empId){
        Employee emp = service.deleteEmployee(empId);
        if(null == emp)
            throw new EmployeeNotFound("No existe ese código de empleado.");
    }*/

}
