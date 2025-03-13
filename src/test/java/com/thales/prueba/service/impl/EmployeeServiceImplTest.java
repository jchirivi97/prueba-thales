package com.thales.prueba.service.impl;

import com.thales.prueba.configuration.VariablesConfig;
import com.thales.prueba.dao.RequestAllEmployeeDao;
import com.thales.prueba.dao.DataRequestAllDao;
import com.thales.prueba.dao.RequestEmployeeDao;
import com.thales.prueba.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private VariablesConfig variablesConfig; // Debe ser @Mock, no @MockBean

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        when(variablesConfig.getUrlAll()).thenReturn("http://mockapi/employees");
        when(variablesConfig.getUrlEmployee()).thenReturn("http://mockapi/employee/");
    }

    @Test
    void testAllEmployee_ReturnsListOfEmployees() {

        DataRequestAllDao emp1 = new DataRequestAllDao();
        emp1.setId(1);
        emp1.setEmployee_name("John Doe");
        emp1.setEmployee_age(30);
        emp1.setEmployee_salary(5000);
        emp1.setProfile_image("profile1.jpg");

        DataRequestAllDao emp2 = new DataRequestAllDao();
        emp2.setId(2);
        emp2.setEmployee_name("Jane Smith");
        emp2.setEmployee_age(28);
        emp2.setEmployee_salary(6000);
        emp2.setProfile_image("profile2.jpg");

        RequestAllEmployeeDao mockResponse = new RequestAllEmployeeDao();
        mockResponse.setData(Arrays.asList(emp1, emp2));

        when(restTemplate.exchange(eq("http://mockapi/employees"), eq(HttpMethod.GET), any(), eq(RequestAllEmployeeDao.class)))
                .thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));


        List<Employee> employees = employeeService.allEmployee();


        assertEquals(2, employees.size());
        assertEquals("John Doe", employees.get(0).getName());
        assertEquals(5000, employees.get(0).getSalary());
        assertEquals("Jane Smith", employees.get(1).getName());

        verify(restTemplate, times(1)).exchange(eq("http://mockapi/employees"), eq(HttpMethod.GET), any(), eq(RequestAllEmployeeDao.class));
    }

    @Test
    void testEmployeebyId_ReturnsSingleEmployee() {

        int employeeId = 1;
        String mockUrl = "http://mockapi/employee/" + employeeId;

        RequestEmployeeDao mockResponse = new RequestEmployeeDao();
        DataRequestAllDao employeeData = new DataRequestAllDao();
        employeeData.setId(employeeId);
        employeeData.setEmployee_name("John Doe");
        employeeData.setEmployee_age(30);
        employeeData.setEmployee_salary(5000);
        employeeData.setProfile_image("profile1.jpg");

        mockResponse.setData(employeeData);

        when(restTemplate.exchange(eq(mockUrl), eq(HttpMethod.GET), any(), eq(RequestEmployeeDao.class)))
                .thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));


        Employee employee = employeeService.employeebyId(employeeId);


        assertNotNull(employee);
        assertEquals(employeeId, employee.getId());
        assertEquals("John Doe", employee.getName());
        assertEquals(30, employee.getAge());
        assertEquals(5000, employee.getSalary());
        assertEquals("profile1.jpg", employee.getProfile_img());

        verify(restTemplate, times(1)).exchange(eq(mockUrl), eq(HttpMethod.GET), any(), eq(RequestEmployeeDao.class));
    }
}
