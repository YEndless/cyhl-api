package com.cy.hl.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 人员信息表
 * 注解：@ApiModel 和 @ApiModelProperty 用于在通过对象接收参数时
 * 在API文档中显示字段的说明
 * 注解：@DateTimeFormat 和 @JsonFormat
 * 用于在接收和返回日期格式时将其格式化
 * 实体类对应的数据表为：
 */

@Data
@Entity
@Table(name = "article")
public class Article{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private int id ;//主键

    @ApiModelProperty(value = "文章标题", required = true)
    private String name ;
    @ApiModelProperty(value = "作者", required = true)
    private String auther ;
    private String avatar ;//头像
    @ApiModelProperty(value = "类型", required = true)
    private int categoryId ;//分类
    private String category ;
    private Date sendTime ;//发布时间
    private int userId ;//作者id
    private String content ;//内容
    private int count ;//评论数
    private int isDelete ;//是否刪除 0 no 1 yes
    public Article() {
    }

}
