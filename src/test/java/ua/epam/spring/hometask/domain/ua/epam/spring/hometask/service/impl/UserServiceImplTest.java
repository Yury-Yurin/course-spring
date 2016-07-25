package ua.epam.spring.hometask.domain.ua.epam.spring.hometask.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import java.io.IOException;


public class UserServiceImplTest {

    @Before
    public void init() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/spring-context.xml");
        userService = (UserService) ctx.getBean("userService");
    }

    UserService userService;

    @Test
    public void saveUserTest() {
        User user = new User("Yury","Yuryn","yhra@tut.by");
        userService.save(user);
        Assert.assertTrue(userService.getAll().size()==1);
    }

    @Test
    public void removeUserTest() {
        User user = new User("Yury","Yuryn","yhra@tut.by");
        userService.save(user);
        Assert.assertTrue(userService.getAll().size()==1);
        userService.remove(user);
        Assert.assertTrue(userService.getAll().size()==0);
    }
    @Test
    public void getUserByIdTest() {
        User user1 = new User("Yury","Yuryn","yhra@tut.by");
        User user2 = new User("Ivan","Yuryn","yhra1@tut.by");
        userService.save(user1);
        userService.save(user2);
        User newUser = userService.getById((long)1);
        Assert.assertEquals(user2,newUser);
    }

    @Test
    public void getUserByEmailTest() throws IOException {
        User user1 = new User("Yury","Yuryn","yhra@tut.by");
        User user2 = new User("Ivan","Yuryn","yhra1@tut.by");
        userService.save(user1);
        userService.save(user2);
        User newUser = userService.getUserByEmail("yhra1@tut.by");
        Assert.assertEquals(user2,newUser);
    }

}
