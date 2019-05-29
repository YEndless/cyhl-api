package com.cy.hl.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    private Integer commentId;//主键
    private Integer articleId;//文章id
    private Integer userId;//评论用户的id
    private String userAvatar ;
    private String userNickname ;
    private String commentContent;//n内容
    private Date commentTime;//shijian
    private int zan ;
}
