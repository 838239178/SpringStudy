package cn.demo.service.impl;

import cn.demo.dao.UserDao;
import cn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("userService")
//@Transactional(propagation = Propagation.REQUIRED) //表示该类下通用的事务属性配置
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //@Transactional(isolation = Isolation.REPEATABLE_READ) //配置事务属性
    public void run() {
        System.out.println(userDao.run());
    }

    @Transactional
    public void transfer(String outMan, String inMan, int money) {
        userDao.send(outMan, money);
        int i = 1/0;
        userDao.receive(inMan, money);
    }

    @Override
    public Boolean login(String usrname, String pwd) {
        return pwd.equals(userDao.getPassword(usrname));
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
