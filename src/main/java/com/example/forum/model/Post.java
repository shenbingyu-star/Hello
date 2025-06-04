package com.example.forum.model;

import java.util.Date;

public class Post {
    private Long id;
    private String title; // 新增 title 属性
    private String content;
    private String author;
    private String board;
    private Date timestamp;

    public Post() {
    }

    public Post(String title, String content, String author, String board) {
        this.title = title; // 新增 title 参数
        this.content = content;
        this.author = author;
        this.board = board;
        this.timestamp = new Date(); // 设置创建时间为当前时间
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() { // 新增 title 的 getter 方法
        return title;
    }

    public void setTitle(String title) { // 新增 title 的 setter 方法
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}