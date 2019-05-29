package com.cy.hl.dao;

import com.cy.hl.entity.Relationship;
import com.cy.hl.entity.RelationshipPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Relationship,RelationshipPK> {
    /**
     * 根据关注者id查找所有记录（查找关注的人的id）
     *
     * @param fromUserId
     * @return
     */
    @Query("select toUserId from Relationship where fromUserId =:fromUserId")
    List<Integer> findByFromUserId(@Param("fromUserId") Integer fromUserId);
    /**
     * 根据被关注者查找所有记录（查找粉丝的id）
     *
     * @param toUserId
     * @return
     */
    @Query("select fromUserId from Relationship where toUserId =:toUserId")
    List<Integer> findByToUserId(@Param("toUserId") Integer toUserId);
    /**
     * 查询该用户的互相关注id
     * @param userId
     * @return
     */
    @Query(value = "SELECT DISTINCT t1.from_user_id FROM (SELECT * FROM relationship WHERE to_user_id = ?1)  AS t1 INNER JOIN relationship t2 ON t1.from_user_id = t2.to_user_id", nativeQuery = true)
    List<Integer> findFriendsByUserId(Integer userId);
    /**
     * 查询关注数
     * @param fromUserId
     * @return
     */
    Integer countByFromUserId(Integer fromUserId);
    /**
     * 查询粉丝数
     * @param toUserId
     * @return
     */
    Integer countByToUserId(Integer toUserId);
}
