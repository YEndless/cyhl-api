package com.cy.hl.Service;

import com.cy.hl.entity.Ad;

import java.util.List;

public interface AdService{
    List<Ad> findAll() ;
    void delete(int id ) ;
    Ad save(Ad ad) ;
    int update(String a1,String  a2) ;

     String getUpToken() ;

}
