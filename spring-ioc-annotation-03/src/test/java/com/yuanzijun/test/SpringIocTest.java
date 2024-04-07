package com.yuanzijun.test;

import com.yuanzijun.ioc_01.XxxDao;
import com.yuanzijun.ioc_02.JavaBean;
import com.yuanzijun.ioc_03.UserController;
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

    @Test
    public void testIoc_02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        JavaBean javaBean = applicationContext.getBean(JavaBean.class);
        JavaBean javaBean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(javaBean == javaBean1);

        applicationContext.close();

    }

    @Test
    public void testIoc_03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        UserController userController = applicationContext.getBean(UserController.class);

        //ioc有接口对应的实现类对象
        userController.show();

        //无
        //@Autowired 使用它进行装配【默认】

        //同一个类型有多个对应的组件，会报错
        //1、默认根据成员属性名指定
        //2、@Qualifier(value = "userServiceImpl") 来指定获取bean的id，必须配合@Autowired
        //@Autowired + @Qualifier(value = "userServiceImpl") == @Resource


    }

    @Test
    public void testIoc_04(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        com.yuanzijun.ioc_04.JavaBean bean = applicationContext.getBean(com.yuanzijun.ioc_04.JavaBean.class);

        System.out.println("bean:" + bean);

    }

}
