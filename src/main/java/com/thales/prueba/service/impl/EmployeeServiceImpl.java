package com.thales.prueba.service.impl;

import com.thales.prueba.configuration.VariablesConfig;
import com.thales.prueba.dao.RequestAllEmployeeDao;
import com.thales.prueba.dao.RequestEmployeeDao;
import com.thales.prueba.model.Employee;
import com.thales.prueba.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

    private final RestTemplate restTemplate;

    @Autowired
    private VariablesConfig variablesConfig;


    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> allEmployee() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<RequestAllEmployeeDao> listEmployee = restTemplate.exchange(
                variablesConfig.getUrlAll(),
                HttpMethod.GET,
                entity,
                RequestAllEmployeeDao.class
        );

        List<Employee> employees = listEmployee.getBody().getData().stream().map(
          data ->{
              Employee employee = new Employee();
              employee.setId(data.getId());
              employee.setAge(data.getEmployee_age());
              employee.setName(data.getEmployee_name());
              employee.setSalary(data.getEmployee_salary());
              employee.setProfile_img(data.getProfile_image());
              return employee;
          }
        ).collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee employeebyId(int id) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<RequestEmployeeDao> requestEmployeeDao = restTemplate.exchange(
                variablesConfig.getUrlEmployee()+id,
                HttpMethod.GET,
                entity,
                RequestEmployeeDao.class
        );

        Employee employee = new Employee();

        employee.setId(requestEmployeeDao.getBody().getData().getId());
        employee.setName(requestEmployeeDao.getBody().getData().getEmployee_name());
        employee.setAge(requestEmployeeDao.getBody().getData().getEmployee_age());
        employee.setSalary(requestEmployeeDao.getBody().getData().getEmployee_salary());
        employee.setProfile_img(requestEmployeeDao.getBody().getData().getProfile_image());

        return employee;

    }
}
