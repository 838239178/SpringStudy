package cn.demo.service.impl;

import cn.demo.dao.UserDao;
import cn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void run() {
        userDao.run();
    }

    @PostConstruct
    public void init() {
        System.out.println("init service");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy service");
    }
}
