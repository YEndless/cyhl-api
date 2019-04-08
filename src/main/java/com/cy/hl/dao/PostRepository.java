package com.cy.hl.dao;

import com.cy.hl.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>{
    Post findById(long id) ;
}
