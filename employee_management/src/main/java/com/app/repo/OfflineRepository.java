package com.app.repo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class OfflineRepository {

    public static List<Employee> getEmployees(){
        List<Employee> empList = new ArrayList<>();
        System.out.println("se agrego employee en OfflineRepository employeemanagement");
        empList.add(new Employee(123,"Darling","Masaya",505));
        empList.add(new Employee(456,"Lucia","Managua",506));
        empList.add(new Employee(789,"Mario","Niquinohomo",507));
        empList.add(new Employee(100,"Gema","Panama",508));
        empList.add(new Employee(200,"sofia","Rusia",456));
        empList.add(new Employee(300,"Pedro","Peru",785));
        return empList;
    }
}
