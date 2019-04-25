package com.cy.hl.Controller;

import com.cy.hl.Service.ReplyService;
import com.cy.hl.entity.Reply;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/reply")
@CrossOrigin
public class ReplyController {
    @Resource
    private ReplyService replyService ;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Reply save(@RequestBody Reply reply){
        return replyService.save(reply);
    }

    @GetMapping("/all")
    public List<Reply> findall(){
        return replyService.findAll();
    }
}
