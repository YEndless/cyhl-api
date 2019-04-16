package com.cy.hl.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name ="reply")

public class Reply{
    @Id
    @GeneratedValue
    private  int Id ; //回复表id
    private String test ;//回复的用户账号
//    private Timestamp ReplyCreattime ;//插入时间
//    private String  ReplyContent ; //回复的内容
//    private String ReplyAuther ;//给谁回复
//    private String ReplyWords ;//在哪个留言下的回复
//    private int ReplyContentId ;//那篇分享下的回复
//    private int ReplyState ;//

}
