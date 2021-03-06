package com.cy.hl.dao;

import com.cy.hl.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Integer>{
    List<Likes> findByAticleidAndUserId(int article , int userid);

    @Transactional
    @Modifying
    @Query("update Likes as l set l.status = ?1 where l.id=?2")
    void update(String password, int id);
}
