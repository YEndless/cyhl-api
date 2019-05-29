package com.cy.hl.IService;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.dao.ArticleRepository;
import com.cy.hl.dao.CommentRepository;
import com.cy.hl.dao.ReplyRepository;
import com.cy.hl.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleRepository articleRepository ;
    @Resource
    CommentRepository commentRepository ;
    @Resource
    ReplyRepository replyRepository ;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAllDesc();
    }
    @Override
    public Article save(Article article) {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.format(date);
        article.setSendTime(date);
        return articleRepository.save(article);
    }

    @Override
    public Article get(int id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void deleteByUId(int userId) {
        articleRepository.deleteByUId(userId);
    }

    @Override
    public List<Article> getAllArticle(int userId) {
        return articleRepository.findByUserId(userId);
    }

    @Override
    public void search(int id) {
        articleRepository.search(id);
    }

    @Override
    public int zan(int count, int id) {
        count ++ ;
        return  articleRepository.update(count,id) ;
    }


}
