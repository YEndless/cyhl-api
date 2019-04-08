package com.cy.hl.Service;

import com.cy.hl.entity.Comment;
import com.cy.hl.entity.Post;

import java.util.List;

public interface CommentService {
    List<Comment> findAll() ;

    public void removeComment(Long id) ;

    public Comment getCommentById(Long id) ;

    public Integer countCommentSizeByPost(Post post) ;

    public void createComment(Long postId, String commentContent) ;

    public void replyComment(Long postId, Long commentId, Long replyId, String commentContent) ;
}
