package com.cy.hl.Controller;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.Service.LikesService;
import com.cy.hl.entity.Likes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

////    添加事务支持
//    @Transactional
//    @RequestMapping("/like")
//    public String likes(@Param("articleid") int articleid , @Param("userid") int userid, Model model){
//        //查询是否有该用户对该文章的点赞记录
//        List<Likes> likesList = likesService.findByAticleidAndUserId(articleid, userid) ;
//        if (likesList != null && likesList.size()>0){
//            //如果找到了这条记录，则删除该记录，同时文章的点赞数减1
//            Likes likes = likesList.get(0) ;
//            likesService.delete(likes.getId());
//            //文章点赞数减1
//            Article article = articleService.get(articleid);
//            article.setLikesNum(article.getLikesNum()-1);
//            articleService.save(article);
//        }else {
//            Likes likes = new Likes();
//            likes.setAticleid(articleid);
//            likes.setUserId(userid);
//            //添加记录
//            likesService.save(likes) ;
//            //文章点赞加1
//            Article article = articleService.get(articleid) ;
//           article.setLikesNum(article.getLikesNum()+1);
//           articleService.save(article);
//        }
//        model.addAttribute("details",articleService.findAll());
////        map.put("details",articleService.findAll());
//
//        return "detail" ;
//    }
}
