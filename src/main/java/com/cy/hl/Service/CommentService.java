package com.cy.hl.Service;

import com.cy.hl.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment) ;
    void deleteComment(int id ) ;
    List<Comment> findAll() ;
    int zan(int zan, int commentId) ;

}
