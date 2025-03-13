package com.thales.prueba.controller;


import com.thales.prueba.model.Employee;
import com.thales.prueba.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<List<Employee>> getClientAll(){

        List<Employee> employees = employeeService.allEmployee();

        return ResponseEntity.ok(employees);

    }

    @RequestMapping(method = RequestMethod.POST, path = "/employee")
    public  ResponseEntity<Employee> getClient(@RequestBody Employee employee){

        Employee restEmployee = employeeService.employeebyId(employee.getId());

        return ResponseEntity.ok(restEmployee);
    }
}
