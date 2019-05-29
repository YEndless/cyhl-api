package com.cy.hl.Service;

import com.cy.hl.entity.Feedback;

import java.util.List;

public interface FeedbavkService {
    List<Feedback> findAll() ;

    Feedback save(Feedback feedback) ;

    void delete (int id ) ;
}
