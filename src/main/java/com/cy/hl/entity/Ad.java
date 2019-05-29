package com.cy.hl.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Ad {
    @Id
    @GeneratedValue
    private Integer id;//主键
    private String adPic ;
    private String adUrl ;
    private String type;
    private String company;
    private String address ;

    private int tel ;
}

