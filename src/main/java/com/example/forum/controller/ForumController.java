package com.example.forum.controller;

import com.example.forum.model.Comment;
import com.example.forum.model.Post;
import com.example.forum.model.User;
import com.example.forum.service.CommentService;
import com.example.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

     //显示论坛页面forum
    @GetMapping("/")
    public String showForum(Model model) {
        List<Post> posts = postService.getAllPosts();
        Map<Long, List<Comment>> commentsMap = new HashMap<>();

        for (Post post : posts) {
            List<Comment> comments = commentService.getCommentsByPostId(post.getId());
            commentsMap.put(post.getId(), comments);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("commentsMap", commentsMap);
        return "forum";
    }


    @GetMapping("/forum")
    public String getForum(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "forum";
    }

    // 添加帖子
    @PostMapping("/add")
    public String addPost(
            @RequestParam("title") String title, // 新增 title 参数
            @RequestParam("content") String content,
            @RequestParam("board") String board,
            HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/auth/login";
        }

        // 使用 title 参数创建新的 Post 对象
        Post newPost = new Post(title, content, currentUser.getUsername(), board);
        postService.addPost(newPost);
        return "redirect:/";
    }

    // 添加评论
    @PostMapping("/comment")
    public String addComment(@RequestParam Long postId,
                             @RequestParam String content,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            redirectAttributes.addFlashAttribute("error", "请先登录");
            return "redirect:/auth/login";
        }

        try {
            Comment comment = new Comment();
            comment.setPostId(postId);
            comment.setUserId(currentUser.getId());
            comment.setUsername(currentUser.getUsername());
            comment.setContent(content);
            comment.setCreatedAt(new Date()); // 设置创建时间为当前时间

            commentService.addComment(comment);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "评论失败: " + e.getMessage());
        }

        return "redirect:/";
    }
}