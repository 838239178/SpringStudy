package cn.demo.mapper;

import cn.demo.bean.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserMapper {

    @Select("select * from account where usrname=#{usrname}")
    List<Account> getUserData(String usrname);
}
