package cn.demo.dao.impl;

import cn.demo.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("run impl");
    }

}
