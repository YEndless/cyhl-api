package com.cy.hl.IService;

import com.cy.hl.Service.ReplyService;
import com.cy.hl.dao.ReplyRepository;
import com.cy.hl.entity.Reply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Resource
    private ReplyRepository replyRepository ;

    @Override
    public Reply save(Reply reply) {
//        Date date = reply.getCreatTime();
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.format(date);
        reply.setCreatTime(date);
        return replyRepository.save(reply);
    }

    @Override
    public List<Reply> findAll() {
        return replyRepository.findAll();
    }
}
