package com.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(generator="my_seq_dep")
    @SequenceGenerator(name="my_seq_dep",sequenceName="SEQ_CURSO_DEPT", allocationSize=1)
    private Long id;
    private String department;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Department() {
    }

    public Department(Long id, String department) {
        this.id = id;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
