package com.yuanzijun;

import com.yuanzijun.ioc_03.HappyComponent;
import com.yuanzijun.ioc_04.JavaBean2;
import com.yuanzijun.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    public void createIoC() {
        //创建容器 选择合适的容器即可

        //方式一：直接创建容器并指定配置文件{推荐}
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        //方法二：创建ioc容器，指定配置文件，再刷新
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();

        applicationContext1.setConfigLocations("spring-03.xml");

        applicationContext1.refresh();//刷新

    }

    @Test
    public void getBeanFromIoC() {

        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        applicationContext.refresh();

        //2.读取ioc容器的组件
        //方法一：（需要强转）
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

        //方法二：根据beanId，同时指定bean的类型
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

        //方案三：直接根据类型获取，但是可以根据接口类型获取值！
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        happyComponent2.doWork();
        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent1 == happyComponent2);

    }

    /**
     * 测试ioc配置的初始化与销毁
     */
    @Test
    public void test_04() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        //ioc会立即释放，死掉；

        JavaBean2 javaBean = applicationContext.getBean(JavaBean2.class);

        JavaBean2 javaBean2 = applicationContext.getBean(JavaBean2.class);
        System.out.println(javaBean2 == javaBean);

        //正常结束ioc容器
        applicationContext.close();
    }

    @Test
    public void test_05(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");
        //ioc会立即释放，死掉；

        JavaBean javaBean = applicationContext.getBean("javaBean",JavaBean.class);
        System.out.println("javaBean = " + javaBean);

        //FactoryBean工厂其实也会加入到ioc容器中，名字 &id
        Object bean = applicationContext.getBean("&javaBean");
        System.out.println("bean = " + bean);

        //正常结束ioc容器
        applicationContext.close();
    }

}
