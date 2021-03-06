package cn.demo.service;

import cn.demo.bean.Account;

import java.util.List;

public interface UserService {
    List<?> run();
    void transfer(String outMan, String inMain, int money);
    Boolean login(String usrname, String pwd);
    Account getUserData(String usrname);
}
