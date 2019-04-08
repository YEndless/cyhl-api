package com.cy.hl.dao;

import com.cy.hl.entity.Comment;
import com.cy.hl.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment ,Long>{
    /**
     * 统计某篇文章有多少条评论
     * @param post
     * @return
     */
    Integer countByPost(Post post);

}
