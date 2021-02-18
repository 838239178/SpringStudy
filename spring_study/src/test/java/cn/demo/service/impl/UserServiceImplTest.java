package cn.demo.service.impl;

import cn.demo.config.SpringConfiguration;
import cn.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
        userService.run();
    }

    @Test
    public void test2() {
        System.out.println(jdbcTemplate);
        System.out.println(jdbcTemplate.getDataSource());
        jdbcTemplate.update("insert into dbo.account values ('jdbc', 'soeasy')");
    }
}
