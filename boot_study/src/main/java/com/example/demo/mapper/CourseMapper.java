package com.example.demo.mapper;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity com.example.demo.domain.Course
 */
@Repository
public interface CourseMapper {

    @Select("select * from cou where cno = #{cno}")
    Course findByCno(int cno);

    @Select("select * from cou, sc where sc.cno=cou.cno and sc.sno = #{sno}")
    List<Course> findAllBySno(int sno);
}




