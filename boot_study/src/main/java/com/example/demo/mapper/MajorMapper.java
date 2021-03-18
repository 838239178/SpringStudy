package com.example.demo.mapper;

import com.example.demo.domain.Major;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.example.demo.domain.Major
 */
@Repository
public interface MajorMapper {

    @Select("select * from major where mno = #{mno}")
    Major findByMno(int mno);
}




