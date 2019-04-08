package com.cy.hl.Controller;

import com.cy.hl.Service.UserService;
import com.cy.hl.entity.LoginUser;
import com.cy.hl.entity.User;
import com.cy.hl.vo.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:81")
public class UserController {
    @Resource
    private UserService userService;

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
}