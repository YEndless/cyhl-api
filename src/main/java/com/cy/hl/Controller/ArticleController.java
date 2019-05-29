package com.cy.hl.Controller;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.Service.CommentRelationService;
import com.cy.hl.Service.CommentService;
import com.cy.hl.entity.Article;
import com.cy.hl.entity.Comment;
import com.cy.hl.entity.CommentRelation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/article")
@CrossOrigin
public class ArticleController {
    @Resource
    private ArticleService articleService ;
    @Resource
    private CommentService commentService ;

    @Resource
    private CommentRelationService commentRelationService ;

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

    @RequestMapping (value = "/delete1",method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer id){
        articleService.delete(id);
    }

    @GetMapping("/deleteByUId")
    public void deleteByUserId(int userId){
        articleService.deleteByUId(userId);
    }

    @RequestMapping(value = "/savecomment",method = RequestMethod.POST)
    public Comment saveComment( Comment comment){
        return commentService.saveComment(comment);
    }

    @RequestMapping (value = "/delcomment",method = RequestMethod.DELETE)
    public void deleteComment(@RequestParam Integer id){
        commentService.deleteComment(id);
    }
    @RequestMapping(value = "/allComments",method = RequestMethod.POST)
    public List<Comment> findAllComments(){
        return commentService.findAll();
    }

    @RequestMapping(value = "/insertCommentRelation",method = RequestMethod.POST)
    public CommentRelation insertCommentRelation(@RequestBody CommentRelation commentRelation){
        return commentRelationService.insertCommentRelation(commentRelation);
    }

    @RequestMapping(value = "/searchUser/{id}",method = RequestMethod.GET)
    public String searchUser(@PathVariable int id){
        return commentRelationService.searchUser(id);
    }

    @RequestMapping(value = "/search/{id}",method = RequestMethod.GET)
    public void search(@PathVariable int id){
         articleService.search(id);
    }

    @RequestMapping(value = "/zan" )
    public @ResponseBody
    int zan(@RequestParam("count") int count,@RequestParam("id") Integer id) {
        return articleService.zan(count,id);
    }

    @RequestMapping(value = "/zan1" )
    public @ResponseBody
    int CommentZan(@RequestParam("zan") int zan,@RequestParam("commentId") Integer commentId) {
        return commentService.zan(zan,commentId);
    }
}
