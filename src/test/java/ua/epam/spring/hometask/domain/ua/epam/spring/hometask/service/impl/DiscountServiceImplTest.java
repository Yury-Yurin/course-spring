package ua.epam.spring.hometask.domain.ua.epam.spring.hometask.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.UserService;

/**
 * Created by yury on 7/25/16.
 */
public class DiscountServiceImplTest {

    @Before
    public void init() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/spring-context.xml");
        discountService = (DiscountService) ctx.getBean("discountService");
    }

    DiscountService discountService;


    @Test
    public void test() {
        Assert.assertEquals(0,0);
    }

}
