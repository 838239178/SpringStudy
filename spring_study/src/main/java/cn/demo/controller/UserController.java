package cn.demo.controller;

import cn.demo.bean.Account;
import cn.demo.service.UserService;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/run2")
    public ModelAndView modelAndView(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/run")
    public ModelAndView run() {
        List<?> list = userService.run();
        Map<String, String> map = new HashMap<>();
        map.put("data", list.toString());
        map.put("test", null);
        return new ModelAndView(new FastJsonJsonView(), map);
    }

    @PostMapping("/login2")
    public ModelAndView login(
            @RequestParam("usrname") String username,
            @RequestParam("pwd") String pwd) {
        System.out.println(username);
        Boolean success = userService.login(username, pwd);
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        if(success) {
            map.put("account", userService.getUserData(username));
        }
        return new ModelAndView(new FastJsonJsonView(), map);
    }

    @RequestMapping("/run3")
    @ResponseBody
    public Account test() {
        return new Account();
    }
}
