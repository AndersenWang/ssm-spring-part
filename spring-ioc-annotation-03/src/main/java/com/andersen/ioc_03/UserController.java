package com.andersen.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    // <property userService ...>
    @Autowired(required = false)  // boolean required() default true; 必须有对应类型的组件
            // 佛系装配则可以没有 required＝null boolean required() default false;
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    @Resource
    private UserService userService1;

    public void show() {
        String show = userService.show();
        System.out.println("show = " + show);
    }
}
