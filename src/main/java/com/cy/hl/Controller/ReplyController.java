package com.cy.hl.Controller;

import com.cy.hl.Service.ReplyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/reply")
@CrossOrigin
public class ReplyController {
    @Resource
    private ReplyService replyService ;

//    @RequestMapping(value = "/save",method = RequestMethod.POST)
//    public Reply save(@RequestBody Reply reply){
//        return replyService.save(reply);
//    }
//
//    @GetMapping("/all")
//    public List<Reply> findall(){
//        return replyService.findAll();
//    }
}
