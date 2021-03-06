package cn.demo.domain;

import cn.demo.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface RoleDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}