package com.cy.hl.dao;

import com.cy.hl.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{
    @Transactional
    @Modifying
    @Query(value="delete from article where user_id = ?1", nativeQuery=true)
    void deleteByUId(int UserId);

    @Transactional
    @Modifying
    @Query(value="SELECT * FROM article a LEFT  JOIN user u ON a.user_id = u.id", nativeQuery=true)
    void search(int uid);

    List<Article> findByUserId(int userId) ;
}
