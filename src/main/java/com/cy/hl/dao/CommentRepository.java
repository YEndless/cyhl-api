package com.cy.hl.dao;

import com.cy.hl.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Integer>{
    @Query("select c FROM Comment  c ORDER BY c.id DESC ")
    List<Comment> findAllDesc();

    @Transactional
    @Modifying
    @Query("update Comment as c set c.zan = ?1 where c.commentId=?2")
    int zan(int zan, int commentId);
}
