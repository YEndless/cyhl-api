package com.cy.hl.dao;

import com.cy.hl.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Integer>{
    List<Likes> findByAticleidAndUserId(int article , int userid);

}
