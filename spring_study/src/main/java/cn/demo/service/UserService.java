package cn.demo.service;

public interface UserService {
    void run();
    void transfer(String outMan, String inMain, int money);
    Boolean login(String usrname, String pwd);
}
