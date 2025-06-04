package com.example.forum.controller;

import com.example.forum.model.Comment;
import com.example.forum.model.Post;
import com.example.forum.service.PostService;
import com.example.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public String getIndex(Model model) {
        List<Post> posts = postService.getAllPosts();
        Map<Long, List<Comment>> commentsMap = new HashMap<>();

        for (Post post : posts) {
            List<Comment> comments = commentService.getCommentsByPostId(post.getId());
            commentsMap.put(post.getId(), comments);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("commentsMap", commentsMap);
        return "index"; // 返回视图名称，对应 /WEB-INF/views/index.jsp
    }

    @GetMapping("/search")
    public String searchPosts(@RequestParam String keyword, Model model) {
        List<Post> searchResults = postService.searchPosts(keyword);
        Map<Long, List<Comment>> commentsMap = new HashMap<>();

        for (Post post : searchResults) {
            List<Comment> comments = commentService.getCommentsByPostId(post.getId());
            commentsMap.put(post.getId(), comments);
        }

        model.addAttribute("posts", searchResults);
        model.addAttribute("commentsMap", commentsMap);
        model.addAttribute("searchKeyword", keyword); // 用于在前端显示搜索关键词
        return "index"; // 返回视图名称，对应 /WEB-INF/views/index.jsp
    }


}