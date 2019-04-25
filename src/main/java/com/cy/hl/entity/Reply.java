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
public class Reply{
    @Id
    @GeneratedValue
    private  int Id ;

    private String reply ;
    private Date creatTime ;//插入时间

    public Reply(String reply, Date creatTime) {
        this.reply = reply;
        this.creatTime = creatTime;
    }

    public Reply() {
    }
}
