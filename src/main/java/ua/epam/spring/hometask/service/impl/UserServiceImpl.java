package ua.epam.spring.hometask.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yury on 7/20/16.
 */
public class UserServiceImpl extends ClassPathXmlApplicationContext implements UserService {

    public static Long countId = new Long(0);
    private HashMap<Long,User> users = new HashMap<>();

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        for(Long i=new Long(0);i<users.size(); i++) {
            User user = users.get(i);
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    @Override
    public User save(@Nonnull User object) {
        users.put(countId,object);
        countId ++;
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        for(int i=0;i<users.size(); i++) {
            if(users.get(i).equals(object))
                users.remove(i);
        }
    }

    @Override
    public User getById(@Nonnull Long id) {
            return users.get(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return users.values();
    }

}
