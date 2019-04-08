package com.cy.hl.Controller;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.entity.Article;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/article")
@CrossOrigin("http://localhost:81")
public class ArticleController {
    @Resource
    private ArticleService articleService ;
    @GetMapping("/all")
    public List<Article> findAll(){
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable int id){
        return articleService.get(id) ;
    }

//    @PostMapping("/send")
//    public String aUpload(@RequestBody  Article article) {
//        articleService.save(article) ;
//        return null ;
//    }

}
