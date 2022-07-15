package com.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：archer
 * @date ：Created in 2022/7/12 19:54
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;
    private String password;
}
