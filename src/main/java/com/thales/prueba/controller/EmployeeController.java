package com.thales.prueba.controller;


import com.thales.prueba.model.Employee;
import com.thales.prueba.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Funcion que recibe la petición para consultar todos los empleados
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/employees")
    public ResponseEntity<List<Employee>> getClientAll(){

        List<Employee> employees = employeeService.allEmployee();

        return ResponseEntity.ok(employees);

    }

    /**
     * Funcion para consultar un empleado por Id
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "/employees/{id}")
    public  ResponseEntity<Employee> getClient(@PathVariable("id") int id ){

        Employee restEmployee = employeeService.employeebyId(id);

        return ResponseEntity.ok(restEmployee);
    }
}
