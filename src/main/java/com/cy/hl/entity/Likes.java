package com.cy.hl.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue
    private Integer id;

    private int typeId ;//对应作品或评论的id

    private int aticleid ;//article id 文章的id

    private String type ;//点赞类型 1 作品点赞 2 评论点赞

    private int userId ;//点赞用户id

    private int status ;//点赞状态0 取消 1 有效
}
