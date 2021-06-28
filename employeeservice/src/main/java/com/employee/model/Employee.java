package com.employee.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Employee {
    private int employeId;
    @Size(min=3,max=5,message = "Cantidad de caracteres inválidos para el nombre")
    private String name;
    @Email
    private String email;

    public Employee(int employeId, String name, String email) {
        this.employeId = employeId;
        this.name = name;
        this.email = email;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
