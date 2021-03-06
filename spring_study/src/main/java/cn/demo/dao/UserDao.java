package cn.demo.dao;

import cn.demo.bean.Account;

import java.util.List;

public interface UserDao {
    List<Account> run();
    void send(String name, int money);
    void receive(String name, int money);
    String getPassword(String usrname);
    List<Account> getUserData(String usrname);
}
