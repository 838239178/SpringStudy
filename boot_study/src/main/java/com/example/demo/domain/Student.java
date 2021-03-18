package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class Student implements Serializable {

    private Integer sno;

    private String sname;

    private String gender;

    private String birdate;

    private Major major;

    private String memo;

    private String photo;

    private String email;

    private List<Course> courseList;

    private static final long serialVersionUID = 1L;
}