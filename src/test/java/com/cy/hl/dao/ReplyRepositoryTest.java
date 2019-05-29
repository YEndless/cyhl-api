package com.cy.hl.dao;

import com.cy.hl.Service.ReplyService;
import com.cy.hl.entity.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyRepositoryTest {
    @Resource
    private ReplyService replyService;
    @Test
    public void aaa(){
        Reply reply=new Reply();
//        System.out.println(replyService.save(reply));
    }
}