package com.yuanzijun.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//import javax.annotation.Resource;

@Controller
public class UserController {
    //自动装配注解（DI）
    @Autowired  //(required = false)可佛系装配
                //不推荐使用佛系，装配的后期都会调用，会报空指针
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

//    @Resource(name = "userServiceImpl")
//    private UserService userService1;

    public void show(){
        //调业务层的show
        String show = userService.show();
        System.out.println("show:" + show);
    }
}
