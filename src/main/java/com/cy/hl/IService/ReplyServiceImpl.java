package com.cy.hl.IService;

import com.cy.hl.Service.ReplyService;
import com.cy.hl.dao.ReplyRepository;
import com.cy.hl.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Resource
    ReplyRepository replyRepository;
    @Override
    public List<Reply> findAll() {
        return replyRepository.findAll();
    }
}
