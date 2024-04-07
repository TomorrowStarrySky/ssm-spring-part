package com.yuanzijun.test;

import com.yuanzijun.ioc_01.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void testIoc_01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        XxxDao bean = applicationContext.getBean(XxxDao.class);

        System.out.println("bean:" + bean);

        Object xxxService = applicationContext.getBean("xxxService");

        System.out.println("Service:" + xxxService);

        applicationContext.close();
    }

}
