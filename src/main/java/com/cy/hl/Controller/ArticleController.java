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

    @RequestMapping("/save")
    public Article save(Article article){
        return articleService.save(article) ;
    }

    @RequestMapping (value = "/delete1",method = RequestMethod.POST)
    public void delete(@RequestParam Integer id){
        articleService.delete(id);
    }
    @RequestMapping (value = "/delete",method = RequestMethod.POST)
    public void delete(@RequestBody Article article){
        articleService.delete(article.getId());
    }

//    @GetMapping("/delete1")
//    public void delete1{
//        articleService.delete();
//    }

    @GetMapping("/deleteByUId")
    public void deleteByUserId(int userId){
        articleService.deleteByUId(userId);
    }
}
