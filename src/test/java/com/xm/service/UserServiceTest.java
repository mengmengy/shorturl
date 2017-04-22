package com.xm.service;

import com.xm.repository.UserRepository;
import com.xm.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Meng on 4/21/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @Before
    public void setUp () {
        this.userService = new UserServiceImpl(userRepository);
    }

    @After
    public void destory() {
        userService = null;
    }

    @Test
    public void getAllUserTest () {
        when(userRepository.getAllUser()).thenReturn(this.getListOfUsers());
        List<User> actual = userService.getAllUser();
        assertEquals(actual.size(), this.getListOfUsers().size());
    }


    private List<User> getListOfUsers() {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);
        user1.setUsername("username");
        user1.setFirstName("first name");
        user1.setLastName("last name");
        userList.add(user1);
        return userList;
    }

}
