package com.cy.hl.IService;

import com.cy.hl.Service.ReplyService;
import com.cy.hl.dao.ReplyRepository;
import com.cy.hl.entity.Reply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Resource
    private ReplyRepository replyRepository ;

    @Override
    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply) ;
    }

    @Override
    public List<Reply> findByReply() {
        return replyRepository.findAll();
    }
}
