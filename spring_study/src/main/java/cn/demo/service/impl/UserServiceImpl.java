package cn.demo.service.impl;

import cn.demo.bean.Account;
import cn.demo.dao.UserDao;
import cn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service("userService")
//@Transactional(propagation = Propagation.REQUIRED) //表示该类下通用的事务属性配置
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<Account> run() {
        return userDao.run();
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

    @Override
    public Account getUserData(String usrname) {
        return userDao.getUserData(usrname).get(0);
    }

    //    @PostConstruct
//    public void init() {
//        System.out.println("init service");
//    }
//
//    @PreDestroy
//    public void destroy() {
//        System.out.println("destroy service");
//    }
}
