package com.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Category entity.
 *
 * @author Evan
 * @date 2019/4
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private int id;

    /**
     * Category name in Chinese.
     */
    private String name;
}
