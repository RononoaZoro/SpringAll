package com.springboot.demo.controller;


import com.springboot.demo.entity.Book;
import com.springboot.demo.result.Result;
import com.springboot.demo.result.ResultFactory;
import com.springboot.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Library controller.
 *
 * @author Evan
 * @date 2019/4
 */
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public Result listBooks() {
        return ResultFactory.buildSuccessResult(bookService.list(null));
    }

    @PostMapping("/api/admin/content/books")
    public Result addOrUpdateBooks(@RequestBody @Valid Book book) {
        bookService.addOrUpdate(book);
        return ResultFactory.buildSuccessResult("修改成功");
    }

    @PostMapping("/api/admin/content/books/delete")
    public Result deleteBook(@RequestBody @Valid Book book) {
        bookService.deleteById(book.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @GetMapping("/api/search")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        return ResultFactory.buildSuccessResult(bookService.list(keywords));
    }

    @GetMapping("/api/categories/{cid}/books")
    public Result listByCategory(@PathVariable("cid") int cid) {
        return 0 != cid ? ResultFactory.buildSuccessResult(bookService.listByCategory(cid))
                : ResultFactory.buildSuccessResult(bookService.list(null));

    }

    @PostMapping("/api/admin/content/books/covers")
    public String coversUpload(MultipartFile file) {
        String folder = "D:\\data\\picture";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, UUID.randomUUID() + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
