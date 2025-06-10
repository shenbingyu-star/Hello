package com.example.forum.dao;

import com.example.forum.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Post post) {
        String sql = "INSERT INTO posts (title, content, author, board, timestamp) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                post.getTitle(), // 新增 title 参数
                post.getContent(),
                post.getAuthor(),

                post.getTimestamp());
    }

    public List<Post> findAll() {
        String sql = "SELECT * FROM posts ORDER BY timestamp DESC";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Post.class));
    }

    public Post findById(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(Post.class),
                    id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Post> findByTitleContainingOrContentContaining(String keyword) {
        String sql = "SELECT * FROM posts WHERE title LIKE ? OR content LIKE ? ORDER BY timestamp DESC";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Post.class),
                "%" + keyword + "%",
                "%" + keyword + "%");
    }
    public List<Post> findByAuthor(String author) {
        String sql = "SELECT * FROM posts WHERE author = ? ORDER BY timestamp DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class), author);
    }
}