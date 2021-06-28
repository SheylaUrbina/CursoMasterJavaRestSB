package com.app.config;

import com.app.repo.Employee;
import com.app.service.EmployeeServiceImpl;
import com.personal.scul.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class EndPointConfiguration {

    @Autowired
    EmployeeServiceImpl services;

    @PayloadRoot(namespace = "http://personal.com/scul",localPart = "GetEmployeeRequest")
    @ResponsePayload
    public JAXBElement<GetEmployeeResponse> getEmployee(@RequestPayload GetEmployeeRequest request){
        GetEmployeeResponse response = new GetEmployeeResponse();
        Employee employee = services.getEmployee(request.getEmployeeId());
        response.setEmployeeDetails(mapEmployee(employee));

        return new ObjectFactory().createGetEmployeeResponse(response);
    }

    @PayloadRoot(namespace = "http://personal.com/scul",localPart = "GetAllEmployeeRequest")
    @ResponsePayload
    public  JAXBElement<GetAllEmployeeResponse> getAllEmployees(@RequestPayload GetAllEmployeeRequest request){
        GetAllEmployeeResponse response = new GetAllEmployeeResponse();
        List<EmployeeDetails> allEmployeeDetail = services.getAllEmployees().stream().map(emp -> mapEmployee(emp)).collect(Collectors.toList());
        response.getEmployeeDetails().addAll(allEmployeeDetail);
        return new ObjectFactory().createGetAllEmployeeResponse(response);
    }

    @PayloadRoot(namespace = "http://personal.com/scul",localPart = "RemoveEmployeeRequest")
    @ResponsePayload
    public  JAXBElement<RemoveEmployeeResponse> removeEmployee(@RequestPayload RemoveEmployeeRequest request){
        RemoveEmployeeResponse response = new RemoveEmployeeResponse();
        boolean status = services.removeEmployee(request.getEmployeeId());
        response.setStatus(status);

        return new ObjectFactory().createRemoveEmployeeResponse(response);
    }

    private EmployeeDetails mapEmployee(Employee employee) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployeeId(employee.getEmployeeId());
        employeeDetails.setEmployeeName(employee.getEmployeeName());
        employeeDetails.setLocation(employee.getLocation());
        employeeDetails.setZipcode(employee.getZipcode());
        return  employeeDetails;
    }
}
