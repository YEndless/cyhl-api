package com.cy.hl.Service;

import com.cy.hl.entity.Likes;

import java.util.List;

public interface LikesService {
    List<Likes> findAll();
    List<Likes> findByAticleidAndUserId(int article , int userid) ;
    void delete(Integer id ) ;

   Likes save (Likes likes) ;
}
