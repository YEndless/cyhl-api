package com.cy.hl.Service;

import com.cy.hl.entity.Picture;

import java.util.List;

public interface PictureService {
    List<Picture> findAll() ;
    List<Picture>  findAllBylike ();

    Picture save(Picture picture) ;

    Picture get(int id) ;

    void delete(int id ) ;

    int zan(int zan , int id ) ;

    void deleteByUid(int uid) ;
}
