package com.springboot.demo.controller;

import com.springboot.demo.result.Result;
import com.springboot.demo.result.ResultCode;
import com.springboot.demo.result.ResultFactory;
import com.springboot.demo.service.UserService;
import com.springboot.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author ：archer
 * @date ：Created in 2022/7/12 19:52
 * @description：
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/api/login")
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, password);
        session.setAttribute("user", user);
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
//        usernamePasswordToken.setRememberMe(true);
        return Objects.nonNull(user) ? ResultFactory.buildResult(ResultCode.SUCCESS, null, user) : ResultFactory.buildResult(ResultCode.FAIL, null, user);
    }
}
