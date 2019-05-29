package com.cy.hl.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Picture {
    @Id
    @GeneratedValue
    private Integer id;//主键
    private int userId ;
    private String user ;//yonghu 头像
    private String pic ;
    private String type;//leixing
    private int zan ;
    private Date sendTime ;
    private String userAvatar ;
    private String header ; //biaoti
    private int status ;
}