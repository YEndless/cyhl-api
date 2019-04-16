package com.cy.hl.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String email ;
    @Column(nullable = false)
    private String password ;
    private String nickName ;
    private String phoneNumb ;
    private String avatar ;
    private Integer follow ; //关注
    private Integer follower ;//粉丝

}
