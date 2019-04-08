package com.cy.hl.dao;

import com.cy.hl.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{
//    Article findByIdForUpdate(Integer id) ;
//    Article findFirstBy() ;


}
