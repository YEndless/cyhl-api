package com.cy.hl.dao;

import com.cy.hl.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Integer> {

    @Query("select p FROM Picture  p ORDER BY p.sendTime DESC ")
    List<Picture> findAllDesc();

    @Query("select p FROM Picture  p ORDER BY p.zan DESC ")
    List<Picture> findAllBylike() ;

    @Transactional
    @Modifying
    @Query("update Picture as p set p.zan = ?1 where p.id=?2")
    int update(int zan, int id);

    List<Picture> findByUserId(int userId) ;

    @Transactional
    @Modifying
    @Query(value="delete from picture where user_id = ?1", nativeQuery=true)
    void deleteByUId(int UserId);
}