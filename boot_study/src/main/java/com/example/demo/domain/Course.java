package com.example.demo.domain;

import java.io.Serializable;
import lombok.Data;


@Data
public class Course implements Serializable {

    private Integer cno;


    private String cname;


    private Integer credit;

    private Integer ptime;

    private static final long serialVersionUID = 1L;
}