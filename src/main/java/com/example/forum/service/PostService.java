package com.example.forum.service;

import com.example.forum.dao.PostRepository;
import com.example.forum.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post addPost(Post post) {
        postRepository.save(post);
        return post;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContainingOrContentContaining(keyword);
    }
    public List<Post> getUserPosts(String username) {
        return postRepository.findByAuthor(username);
    }
}