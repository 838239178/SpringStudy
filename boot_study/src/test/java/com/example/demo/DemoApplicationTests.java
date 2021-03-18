package com.example.demo;

import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

    @Autowired
    private StudentMapper stuMapper;

    @Test
    void contextLoads() {
        System.out.println("123");
    }

    @Test
    void DaoTest() throws Exception{
        Student stu = stuMapper.findBySno(7);
        System.out.println(stu);
    }
}
