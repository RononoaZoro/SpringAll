package com.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Book entity.
 *
 * @author Evan
 * @date 2019/4
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;

    /**
     * Title of the book.
     */
    private String title;

    /**
     * Author name.
     */
    private String author;

    /**
     * Publication date.
     */
    private String date;

    /**
     * Press.
     */
    private String press;

    /**
     * Abstract of the book.
     */
    private String abs;

    /**
     * The url of the book's cover.
     */
    private String cover;

    /**
     * Category id.
     */
//    private Category category;
}
