package com.cy.hl.Service;

import com.cy.hl.entity.CommentRelation;

public interface CommentRelationService {

    CommentRelation insertCommentRelation(CommentRelation commentRelation);

    void deleteCommentRelation(CommentRelation commentRelation);

    String searchUser(int id) ;
}
