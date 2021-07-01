package com.employee.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDao {
    static List<Employee> list = new ArrayList<>();

    static {
        list.add(new Employee((long) 1234,"Darling","darling@gmail.com"));
        list.add(new Employee((long) 45,"Maria","maria@gmail.com"));
        list.add(new Employee((long) 58,"John","john@gmail.com"));
        list.add(new Employee((long) 80,"Marta","marta@gmail.com"));
        list.add(new Employee((long) 98,"Rosa","rosa@gmail.com"));
        list.add(new Employee((long) 198,"Jack","jack@gmail.com"));
        list.add(new Employee((long) 8,"Jim","jim@gmail.com"));

    }

    public List<Employee> getAllEmployees() {
        return list;
    }

    public Employee getEmployeeById(int empId) {
        return list.stream().filter(emp -> emp.getId()== empId).findAny().orElse(null);
    }

    public Employee saveEmployee(Employee emp) {
        emp.setId((long)list.size()+1);
        list.add(emp);
        return emp;
    }

    public Employee deleteEmployee(int empId) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee emp =iterator.next();
            if(empId == emp.getId()){
                iterator.remove();
                return emp;
            }
        }
        return null;

    }
}
