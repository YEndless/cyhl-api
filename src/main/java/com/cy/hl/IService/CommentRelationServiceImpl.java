package com.cy.hl.IService;

import com.cy.hl.Service.CommentRelationService;
import com.cy.hl.dao.CommentRelationRepository;
import com.cy.hl.entity.CommentRelation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentRelationServiceImpl implements CommentRelationService {
    @Resource
    private CommentRelationRepository commentRelationRepository ;

    @Override
    public CommentRelation insertCommentRelation(CommentRelation commentRelation) {
        return commentRelationRepository.save(commentRelation);
    }

    @Override
    public void deleteCommentRelation(CommentRelation commentRelation) {
        commentRelationRepository.deleteCommentRelationByCommentIdAndUserId(commentRelation.getCommentId(),commentRelation.getUserId());
    }

    @Override
    public String searchUser(int id) {
        return commentRelationRepository.search(id);
    }
}
