package com.example.forum.controller;

import com.example.forum.model.Comment;
import com.example.forum.model.Post;
import com.example.forum.model.User;
import com.example.forum.service.CommentService;
import com.example.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// src/main/java/com/example/forum/controller/UserController.java
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            return "redirect:/auth/login";
        }
        model.addAttribute("user", user);
        return "profile";
    }
    @GetMapping("/posts")
    public String getUserPosts(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/auth/login";
        }
        List<Post> userPosts = postService.getUserPosts(currentUser.getUsername());
        Map<Long, List<Comment>> commentsMap = new HashMap<>();

        for (Post post : userPosts) {
            List<Comment> comments = commentService.getCommentsByPostId(post.getId());
            commentsMap.put(post.getId(), comments);
        }

        model.addAttribute("posts", userPosts);
        model.addAttribute("commentsMap", commentsMap);
        model.addAttribute("isUserPosts", true); // 标记这是用户帖子页面
        return "index";
    }
}