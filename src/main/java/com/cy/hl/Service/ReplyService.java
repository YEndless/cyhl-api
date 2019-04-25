package com.cy.hl.Service;

import com.cy.hl.entity.Reply;

import java.util.List;

public interface ReplyService {
    Reply save(Reply reply) ;

    List<Reply> findAll();
}
