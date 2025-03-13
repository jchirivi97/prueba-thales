package com.thales.prueba.service;


import com.thales.prueba.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> allEmployee();

    Employee employeebyId(int id);
}
