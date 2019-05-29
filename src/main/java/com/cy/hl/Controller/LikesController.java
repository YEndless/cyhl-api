package com.cy.hl.Controller;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.Service.LikesService;
import com.cy.hl.entity.Likes;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/likes")
@CrossOrigin
public class LikesController {

    @Resource
    private LikesService likesService ;

    @Resource
    private ArticleService articleService ;

    @GetMapping("/all")
    public List<Likes> findAll(){
        return  likesService.findAll();
    }

    @RequestMapping("/save")
    public Likes save(Likes Likes){
        return likesService.save(Likes) ;
    }


}
