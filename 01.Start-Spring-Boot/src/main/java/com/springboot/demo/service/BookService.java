package com.springboot.demo.service;

import com.springboot.demo.entity.Book;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：archer
 * @date ：Created in 2022/7/21 15:54
 * @description：
 */
@Service
public class BookService {

    private List<Book> list;

    public BookService() {
        this.list = findAll();
    }

    public List<Book> list(String keyWords) {

        return StringUtils.isEmpty(keyWords) ? this.list
                : this.list.stream()
                .filter(book -> book.getTitle().contains(keyWords) || keyWords.equalsIgnoreCase(book.getId() + ""))
                .collect(Collectors.toList());
    }

    public List<Book> listByCategory(int cid) {
        return this.list;
    }


    private List<Book> findAll() {
        List<Book> list = Lists.newArrayList();
        list.add(new Book(1, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(2, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(3, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(4, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(5, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(6, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(7, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(8, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(9, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(10, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(11, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(12, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(13, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(14, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(15, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(16, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(17, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(18, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        list.add(new Book(19, "三体", "刘慈欣", "2019-05-05", "重庆出版社", "文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……", "https://i.loli.net/2019/04/10/5cada7e73d601.jpg"));
        return list;
    }

    public void addOrUpdate(Book book) {
        this.list.add(book);
    }

    public void deleteById(int id) {
        this.list.removeIf(book -> book.getId() == id);
    }
}
