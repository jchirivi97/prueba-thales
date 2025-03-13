package com.thales.prueba.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int id;
    private String name;
    private int salary;
    private int age;
    private String profile_img;

    public Employee(int i, String jane_smith, int i1, int i2, String s) {
    }

    public Employee(){

    }
}
