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
    public List<Account> getUserData(String usrname) {
        return jdbcTemplate.query("select * from account where usrname = ?", new BeanPropertyRowMapper<>(Account.class), usrname);
    }

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

    private <T> T queryForObject(String sql, Class<T> clazz, Object... args) {
        return jdbcTemplate.queryForObject(sql, args, clazz);
    }

    @Override
    public String getPassword(String usrname) {
        // Object[] args = {usrname};
        return queryForObject("select pwd from account where usrname = ?", String.class, usrname);
//        return jdbcTemplate.queryForObject("select pwd from account where usrname = ?", args, String.class);
    }
}
