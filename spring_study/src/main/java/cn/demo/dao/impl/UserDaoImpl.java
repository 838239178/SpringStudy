package cn.demo.dao.impl;

import cn.demo.bean.Account;
import cn.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> run() {
        List<Account> beans = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        System.out.println("run impl");
        return beans;
    }

    @Override
    public void send(String name, int money) {
        jdbcTemplate.update("update account set money = money-? where usrname = ?", money, name);
    }

    @Override
    public void receive(String name, int money) {
        jdbcTemplate.update("update account set money = money+? where usrname = ?", money, name);
    }

}
