package com.app.service;

import com.app.repo.Employee;
import com.app.repo.OfflineRepository;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Component
public class EmployeeServiceImpl {

    List<Employee> listOfEmployees = OfflineRepository.getEmployees();
    public Employee getEmployee(int employeeid) {
        Optional<Employee> employee = listOfEmployees.stream()
                .filter(emp -> emp.getEmployeeId() == employeeid)
                .findFirst();

        System.out.println("actualizando employee management");
    return employee.get();

    }

    public List<Employee> getAllEmployees() {
        return listOfEmployees;
    }

    public boolean removeEmployee(int employeeId) {
        System.out.println("agregando comentarios a esta clase");
        Iterator<Employee> iterator = listOfEmployees.iterator();
        while(iterator.hasNext()){
            Employee emp = iterator.next();
            if(employeeId== emp.getEmployeeId()){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
