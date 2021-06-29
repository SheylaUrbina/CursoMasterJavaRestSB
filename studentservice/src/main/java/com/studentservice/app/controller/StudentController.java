package com.studentservice.app.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.studentservice.app.model.Student;
import com.studentservice.app.service.StudentDao;
import com.studentservice.app.service.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentDao dao;

    @Autowired
    StudentRespository repo;

    @PostMapping("/saveStudent")
    public void saveStudent(@RequestBody Student student){
        dao.insertStudent(student);
    }

    @PostMapping("/persistStudent")
    public void persistStudent(@RequestBody Student student){
        repo.save(student);
    }

    @GetMapping("allStudent")
    public List<Student> getAllStudent(){
        //hay que aplicar el MappingJacksonValue
        return repo.findAll();
    }

    @GetMapping("getStudentById/{id}")
    public MappingJacksonValue getStudentById(@PathVariable long id){
        //Optional<Student> byId = repo.findById(id);
        //return byId.get();
        Optional<Student> details = repo.findById(id);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("studentname","age");
        FilterProvider filters = new SimpleFilterProvider().addFilter("Student",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(details);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;


    }
}
