package com.cy.hl.dao;

import com.cy.hl.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AdRepository extends JpaRepository<Ad, Integer>{
    @Transactional
    @Modifying
    @Query("update Ad as a set a.adPic = ?1 where a.adUrl=?2")
    int update(String a1, String a2);

}
