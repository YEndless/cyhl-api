package com.cy.hl.Controller;

import com.cy.hl.Service.CommentService;
import com.cy.hl.dao.PostRepository;
import com.cy.hl.entity.Comment;
import com.cy.hl.entity.Post;
import com.cy.hl.entity.User;
import com.cy.hl.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentService commentService;

    /**
     * 发表评论
     *
     * @param postId
     * @param commentId
     * @param commentContent
     * @return
     */
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    public ResponseEntity<Response> createComment(Long postId, Long replyId, Long commentId, String commentContent) {
        try {
            postRepository.findById(postId).get();
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(1,"","文章不存在!"));
        }
        try {
            //1、评论
            if (commentId == null) {
                commentService.createComment(postId, commentContent);
            } else {
                //回复
                commentService.replyComment(postId, commentId, replyId, commentContent);
            }
            //2、修改文章的评论数目
            Post originalPost = postRepository.findById(postId).get();
            originalPost.setCommentSize(commentService.countCommentSizeByPost(originalPost));
            postRepository.save(originalPost);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.ok().body(new Response(0,"false", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(0,"false", e.getMessage()));
        }
        return ResponseEntity.ok().body(new Response(1,"true", "处理成功!"));
    }

    /**
     * 删除评论
     *
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        boolean isOwner = false;
        User user;
        try {
            user = commentService.getCommentById(id).getUser();
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(1, "false", "评论不存在！"));
        }
        // 判断操作用户是否是评论的所有者
        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null) {//&& user.getUsername().equals(principal.getUsername())
                isOwner = true;
            }
        }
        if (!isOwner) {
            return ResponseEntity.ok().body(new Response(0, "false", "没有操作权限！"));
        }
        try {
            Comment originalComment = commentService.getCommentById(id);
            //1、先删除子评论
            List<Comment> commentList = originalComment.getCommentList();
            if (commentList != null && commentList.size() != 0) {
                for (int i = 0; i < commentList.size(); i++) {
                    Comment comment = commentList.get(i);
                    commentService.removeComment(comment.getId());
                }
            }
            //2、删除该评论
            commentService.removeComment(id);
            //3、修改文章的评论数目
//            Post originalPost = originalComment.getPost();
//            originalPost.setCommentSize(commentService.countCommentSizeByPost(originalPost));
//            postRepository.save(originalPost);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.ok().body(new Response(0,"f", "no成功!"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(0,"f", "no成功!"));
        }
            return ResponseEntity.ok().body(new Response(1, "true", "处理成功!"));
        }
}