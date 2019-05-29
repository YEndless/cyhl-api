package com.cy.hl.dao;

import com.cy.hl.entity.CommentRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRelationRepository extends JpaRepository<CommentRelation,Integer>{
    @Transactional
    int deleteCommentRelationByCommentIdAndUserId(Integer commentId,Integer userId);

    @Transactional
    int deleteAllByCommentId(Integer commentId);

    @Transactional
    int deleteAllByUserId(Integer userId);

    List<CommentRelation> findAllByUserId(Integer userId);

    List<CommentRelation>findAllByCommentId(Integer commentId);

//    @Transactional
//    @Modifying
    @Query(value="SELECT nick_name FROM comment,user WHERE comment.user_id = user.id AND comment_id=?", nativeQuery=true)
    String search(int id);
}
