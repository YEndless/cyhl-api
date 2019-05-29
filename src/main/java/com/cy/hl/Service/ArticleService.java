package com.cy.hl.Service;

import com.cy.hl.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll() ;

    Article save(Article article) ;

    Article get(int id) ;

    void delete(int id ) ;

    void deleteByUId(int userId) ;

    List<Article> getAllArticle(int userId) ;

    void search( int id) ;

    int zan(int count , int id) ;
}
