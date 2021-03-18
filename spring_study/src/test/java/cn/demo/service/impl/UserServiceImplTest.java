package cn.demo.service.impl;

import cn.demo.bean.Account;
import cn.demo.config.SpringConfiguration;
import cn.demo.config.mvc.MvcConfiguration;
import cn.demo.config.mvc.WebConfiguration;
import cn.demo.mapper.UserMapper;
import cn.demo.service.UserService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringConfiguration.class, MvcConfiguration.class, WebConfiguration.class})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() {
        userService.run();
    }

    @Test
    public void test2() {
        System.out.println(jdbcTemplate);
        System.out.println(jdbcTemplate.getDataSource());
        jdbcTemplate.update("insert into dbo.account values ('jdbc', 'soeasy', '1000')");
    }

    @Test
    public void test3() {
        List<Account> beans = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(beans);
    }

    @Test
    public void test4() {
        userService.transfer("zhangsan", "wangwu", 500);
    }

    @Test
    public void test5() throws Exception {
        List<Account> list = userMapper.getUserData("zhangsan");
        System.out.println(list);
    }
}
