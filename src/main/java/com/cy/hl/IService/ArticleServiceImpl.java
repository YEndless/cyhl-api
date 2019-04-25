package com.cy.hl.IService;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.dao.ArticleRepository;
import com.cy.hl.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
//    @Autowired
    @Resource
    ArticleRepository articleRepository ;


    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
//    @Override
//    public Article getOne (int id) {
//        return articleRepository.getOne(id);
//    }


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

//    @Override
//    public Article getByUserId() {
//        return articleRepository.f;
//    }

}
