package com.example.forum.model;

import javax.persistence.*;
import java.util.Date;

@Entity // 标记这是一个 JPA 实体类
@Table(name = "users") // 指定数据库中的表名
public class User {
    @Id // 标记这是主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 指定主键生成策略
    private Long id;

    @Column(nullable = false, unique = true) // 指定列不为空且唯一
    private String username;

    @Column(nullable = false) // 指定列不为空
    private String password; // 明文

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // 指定日期字段的类型
    private Date createdAt;

    // 构造方法
    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = new Date(); // 设置创建时间为当前时间
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}