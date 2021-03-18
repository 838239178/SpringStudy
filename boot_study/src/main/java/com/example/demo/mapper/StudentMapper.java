package com.example.demo.mapper;

import com.example.demo.domain.Major;
import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity com.example.demo.domain.Stu
 */
@Repository
public interface StudentMapper {

    @Select("select * from stu where sno = #{sno}")
    @Results(id = "stuMap", value = {
            @Result(id = true, column = "sno", property = "sno"),
            @Result(
                    column = "mno",
                    property = "major",
                    javaType = int.class,
                    one = @One(select = "com.example.demo.mapper.MajorMapper.findByMno")
            ),
            @Result(
                    column = "sno",
                    property = "courseList",
                    many = @Many(select = "com.example.demo.mapper.CourseMapper.findAllBySno")
            )
    })
    Student findBySno(int sno);
}



