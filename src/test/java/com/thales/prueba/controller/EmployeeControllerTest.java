package com.thales.prueba.controller;

import com.thales.prueba.model.Employee;
import com.thales.prueba.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetClientAll_ReturnsListOfEmployees() {

        Employee emp1 = new Employee(1, "John Doe", 5000, 30, "profile1.jpg");
        Employee emp2 = new Employee(2, "Jane Smith", 6000, 28, "profile2.jpg");

        when(employeeService.allEmployee()).thenReturn(Arrays.asList(emp1, emp2));


        ResponseEntity<List<Employee>> response = employeeController.getClientAll();


        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());

        verify(employeeService, times(1)).allEmployee();
    }

    @Test
    void testGetClient_ReturnsEmployeeById() {

        int id = 1;
        Employee emp = new Employee(id, "John Doe", 5000, 30, "profile1.jpg");

        when(employeeService.employeebyId(id)).thenReturn(emp);


        ResponseEntity<Employee> response = employeeController.getClient(id);


        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
        assertEquals("John Doe", response.getBody().getName());

        verify(employeeService, times(1)).employeebyId(id);
    }
}
