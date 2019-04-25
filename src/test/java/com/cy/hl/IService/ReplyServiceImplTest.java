package com.cy.hl.IService;

import com.cy.hl.Service.ReplyService;
import com.cy.hl.entity.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyServiceImplTest {
    @Resource
    private ReplyService replyService;
    @Test
    public void save() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));
        Reply reply = new Reply("2222",date);
        System.out.println(replyService.save(reply));
    }
}