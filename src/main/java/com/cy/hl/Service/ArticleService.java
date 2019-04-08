package com.cy.hl.Service;

import com.cy.hl.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll() ;

    Article getOne(int id);

    Article save(Article article) ;

    Article get(int id) ;
}
