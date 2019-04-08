package com.cy.hl.Controller;

import com.cy.hl.Service.PostService;
import com.cy.hl.entity.Post;
import com.cy.hl.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/post")
public class PostController {

    @Resource
    PostService postService ;
    /**
     * 文章详情页
     *
     * @param username
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/u/{username}/posts/{id}")
    public String getPostById(@PathVariable("username") String username, @PathVariable("id") Long id, Model model) {
        //1、每次读取，简单的可以认为阅读量增加1次
        try {
            postService.readingIncrease(id);
        } catch (Exception e) {
            //文章不存在
        }
        // 2、判断操作用户是否是博客的所有者
        boolean isPostOwner = false;
        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null) {// && username.equals(principal.getUsername())
                isPostOwner = true;
            }
        }
        Post post = postService.getPostById(id);
        model.addAttribute("site_title", post.getTitle() + "-");
        model.addAttribute("isPostOwner", isPostOwner);
        model.addAttribute("post", post);
        return "detail";
    }
}
