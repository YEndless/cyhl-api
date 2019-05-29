package com.cy.hl.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Feedback {
    @Id
    @GeneratedValue
    private Integer id;//主键
    private String userName ;
    private String content ;
    private int userId;
    private Date sendTime ;
    private String category;
}

