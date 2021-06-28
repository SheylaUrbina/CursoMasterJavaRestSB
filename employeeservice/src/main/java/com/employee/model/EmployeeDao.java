package com.employee.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDao {
    static List<Employee> list = new ArrayList<>();

    static {
        list.add(new Employee(1234,"Darling","darling@gmail.com"));
        list.add(new Employee(45,"Maria","maria@gmail.com"));
        list.add(new Employee(58,"John","john@gmail.com"));
        list.add(new Employee(80,"Marta","marta@gmail.com"));
        list.add(new Employee(98,"Rosa","rosa@gmail.com"));
        list.add(new Employee(198,"Jack","jack@gmail.com"));
        list.add(new Employee(8,"Jim","jim@gmail.com"));

    }

    public List<Employee> getAllEmployees() {
        return list;
    }

    public Employee getEmployeeById(int empId) {
        return list.stream().filter(emp -> emp.getEmployeId()== empId).findAny().orElse(null);
    }

    public Employee saveEmployee(Employee emp) {
        emp.setEmployeId(list.size()+1);
        list.add(emp);
        return emp;
    }

    public Employee deleteEmployee(int empId) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee emp =iterator.next();
            if(empId == emp.getEmployeId()){
                iterator.remove();
                return emp;
            }
        }
        return null;

    }
}
