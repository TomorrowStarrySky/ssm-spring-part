package com.yuan.ioc;

import com.yuan.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    @Test
    public void Test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        StudentController studentController = applicationContext.getBean(StudentController.class);

        studentController.findAll();
    }
}
