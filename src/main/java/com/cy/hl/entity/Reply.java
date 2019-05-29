package com.cy.hl.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name ="reply")
public class Reply {
    @Id
    @GeneratedValue
    private Integer replyId;
    private Integer pId;//父评论id
    private Integer userId;//评论人id
    private Integer replyuserId;//被回复人的id
    private String replyContent;
    private Date replyTime;
    private Integer articleId;

    public Reply() {
    }
}