package com.andersen.test;

import com.andersen.ioc_01.XxxDao;
import com.andersen.ioc_02.JavaBean;
import com.andersen.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {

    @Test
    public void testIoC01() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean = " + bean);

        // 默认组件名为 类的首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println("xxxService = " + xxxService);
    }

    @Test
    public void testIoC02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean == bean1);

        applicationContext.close();
    }

    @Test
    public void testIoC03() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        UserController userController = applicationContext.getBean(UserController.class);

        // 1.ioc容器中有一个UserService接口对应的实现类对象！
        userController.show();

        // 2.ioc容器没有默认的类型如何处理
        // ＠Autowired 使用它进行装配，【默认】情况下至少要求有一个bean！否则报错！可以指定佛系装配

        // 3.同一个类型有多个对应的组件＠Autowired也会报错！无法选择！！
        // 解决1：成员属性名指定 ＠Autowired 多个组件的时候，默认会根据成员属性名查找
        // 解决2： ＠Qualifier（value ＝ ＂userServiceImpl＂）使用该注解指定获取bean的id！不能单独使用必须配合autowired

        // 优化点： @Autowired(required = true) + @Qualifier(value = "userServiceImpl") == @Resource(name="userServiceImpl")

        applicationContext.close();
    }

    @Test
    public void testIoC04() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        com.andersen.ioc_04.JavaBean bean = applicationContext.getBean(com.andersen.ioc_04.JavaBean.class);

        System.out.println("bean = " + bean);

        applicationContext.close();
    }
}
