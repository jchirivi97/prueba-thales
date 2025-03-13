package com.thales.prueba.dao;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RequestEmployeeDao {

    private String status;
    private DataRequestAllDao data;
    private String message;

}
