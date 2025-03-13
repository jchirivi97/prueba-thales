package com.thales.prueba.util;

public class EmployeeBussines {

    private int employee_anual_salary;

    public int calculateSalaryAnual(int employee_salary){

        employee_anual_salary = employee_salary * 12;

        return employee_salary;
    }
}
