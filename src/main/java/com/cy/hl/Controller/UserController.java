package com.cy.hl.Controller;

import com.cy.hl.Service.ArticleService;
import com.cy.hl.Service.UserService;
import com.cy.hl.entity.LoginUser;
import com.cy.hl.entity.User;
import com.cy.hl.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ArticleService articleService ;

    @GetMapping("/all")
    public List<User>findAll( ){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id ){
        return userService.findById(id);
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public ResponseUtil signIn(@RequestBody LoginUser loginUser) {
        System.out.println(loginUser);
        return userService.userLogin(loginUser);
    }

    @RequestMapping (value = "/delete1",method = RequestMethod.DELETE)
    public void delete(@RequestParam int id ){
//        articleService.deleteByUId(userId);
        userService.delete(id);
    }

    @RequestMapping (value = "/delete",method = RequestMethod.POST)
    public void delete(@RequestBody User user){
        articleService.delete(user.getId());
    }
//    @RequestMapping (value = "/delete1",method = RequestMethod.POST)
//    public void delete(@RequestParam Integer id){
//        articleService.delete(id);
//    }
    @RequestMapping("/save")
    public User save(User user){
        return userService.save(user);
    }


    @RequestMapping(value = "/update" )
    public @ResponseBody
    void update(@RequestParam("password") String password,@RequestParam("id") Integer id) {
        userService.update(password,id);
    }
    @RequestMapping(value = "/updateAvatar" )
    public @ResponseBody
    void updateAvatar(@RequestParam("avatar") String avatar,@RequestParam("id") Integer id) {
        userService.updateAvatar(avatar,id);
    }

    @RequestMapping(value = "/search")
    public void search(@RequestParam("nickName")String nickName , @RequestParam("password")String password){
    }
}