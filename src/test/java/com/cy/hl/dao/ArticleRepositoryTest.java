package com.cy.hl.dao;

import com.cy.hl.entity.Article;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.Timestamp;


public class ArticleRepositoryTest {
    @Resource
    private ArticleRepository articleRepository;

//    protected Article insert(){
//
//    }
    @Test
    public void insertAricle() {
        Article article = new Article() ;
        article.setId(1);
        article.setHeader("第一篇文章");
        article.setName("dabidaoti");
        article.setDescription("gaiyao概要");
        article.setAuther("yeweiyang");
        article.setCategoryId(1);
        article.setSendTime(Timestamp.valueOf("2009-3-30 14:21:12.123"));
        article.setUserId(1);
        article.setContent("wowowowowowowowowoasdfghjkasdfhjkashdfkljhadsfjklhajf");
        article.setCount(11);
        article.setIsDelete(1);
        article.setIsPublished(1);

        articleRepository.save(article);
    }
}