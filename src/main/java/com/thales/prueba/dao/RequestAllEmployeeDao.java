package com.thales.prueba.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestAllEmployeeDao {

    private String status;
    private List<DataRequestAllDao> data;
    private String message;

}
