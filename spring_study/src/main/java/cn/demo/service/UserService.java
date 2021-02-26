package cn.demo.service;

import java.util.List;

public interface UserService {
    List run();
    void transfer(String outMan, String inMain, int money);
    Boolean login(String usrname, String pwd);
}
