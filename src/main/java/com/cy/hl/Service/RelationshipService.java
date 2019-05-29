package com.cy.hl.Service;


import com.cy.hl.entity.Relationship;
import com.cy.hl.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RelationshipService {
    /**
     * 列出所有的关注者
     *
     * @return
     */
    Page<User> listFollows(Integer userId, Pageable pageable);
    /**
     * 列出所有的粉丝
     *
     * @return
     */
    Page<User> listFans(Integer userId, Pageable pageable);
    /**
     * 列出互相关注的id
     *
     * @param userId
     * @return
     */
    List<Integer> listFriends(Integer userId);
    /**
     * 添加关系
     *
     * @param relationship
     */
    void saveRelationship(Relationship relationship);
    /**
     * 去除关系
     *
     * @param relationship
     */
    void removeRelationship(Relationship relationship);
    /**
     * 更新关注数
     */
    void updateFollowSize(Integer userId);
    /**
     * 更新粉丝数
     */
    void updateFanSize(Integer userId);
}