package com.employee.service;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //Implementing dynamic filters
    @GetMapping("/filter1")
    public MappingJacksonValue filter1(){
        List<UserDetails> details = UserDetails.getDetails();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userId","userName");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserDetails",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(details);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filter2")
    public MappingJacksonValue filter2(){
        List<UserDetails> details = UserDetails.getDetails();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","panNumber");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserDetails",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(details);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }


    /*
    //Forma 1: se utiliza con anotaciones en la clase para solo mostrar lo que no haya sido denotado con @JsonIgnoreProperties(value = {"panNumber"}) a nivel de clase
    //o @JsonIgnore a nivel de campo
    @GetMapping("/filter1")
    public List<UserDetails> filter1(){
        return UserDetails.getDetails();
    }*/

}
//Desaparecen con la forma 2 que es utilizando Dinamic filter (SimpleBeanPropertyFilter)
//donde se especifica por cada metodo qúe es lo que no se mostrara
//@JsonIgnoreProperties(value = {"panNumber"}) //Forma 1 --static filter
//@JsonIgnoreProperties(value = {"panNumber","userId"}) //Forma 1- varios tags que no tome en cuenta --static filter

//Forma 2
@JsonFilter("UserDetails")
class UserDetails{
    private int userId;
    private String userName;
    //@JsonIgnore //Forma 2 se declara sobre el campo que no quiere q aparezca en los response
    private String panNumber;

    public UserDetails(int userId, String userName, String panNumber) {
        this.userId = userId;
        this.userName = userName;
        this.panNumber = panNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public static List<UserDetails> getDetails(){
        return Arrays.asList(new UserDetails(12,"Daniel","AVG001"),
                             new UserDetails(13,"Juan","AVG002"),
                             new UserDetails(14,"Ana","AVG003"));
    }
}
