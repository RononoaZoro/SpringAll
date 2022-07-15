package com.springboot.demo.service;

import com.springboot.demo.vo.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author ：archer
 * @date ：Created in 2022/7/13 16:10
 * @description：
 */
@Service
public class UserService {
    public User findByUsername(String username) {
        if (Objects.equals(username, "xiaoluo")) {
            return new User("xiaoluo", "123456");
        }
        return null;
    }

    public User get(String username, String password) {
        if (Objects.equals(username, "xiaoluo") && Objects.equals(password, "123456")) {
            return new User("xiaoluo", "123456");
        }
        return null;
    }
}
