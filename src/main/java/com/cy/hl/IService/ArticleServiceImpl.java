package com.cy.hl.IService;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.dao.ArticleRepository;
import com.cy.hl.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public Article getOne (int id) {
        return articleRepository.getOne(id);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    @Override
    public Article get(int id) {
        return articleRepository.findById(id).get();
    }
}
