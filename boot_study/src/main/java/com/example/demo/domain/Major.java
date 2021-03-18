package com.example.demo.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Major implements Serializable {

    private Integer mno;

    private String mname;

    private static final long serialVersionUID = 1L;
}