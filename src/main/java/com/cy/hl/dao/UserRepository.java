package com.cy.hl.dao;

import com.cy.hl.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User as u set u.password = ?1 where u.id=?2")
    void update(String password, int id);

    @Transactional
    @Modifying
    @Query(value="SELECT user.password = ?2 FROM user WHERE user.nick_name = ?1", nativeQuery=true)
    void search(String nk ,String pa);

    @Transactional
    @Modifying
    @Query("update User as u set u.avatar = ?1 where u.id=?2")
    void updateAvatar(String avatar, int id);

    //分页
    /**
     * 根据id集合查询用户，分页查询
     *
     * @param ids
     * @return
     */
    Page<User> findByIdIn(List<Integer> ids, Pageable pageable);
    /**
     * 根据id集合查询用户，不分页
     *
     * @param ids
     * @return
     */
    List<User> findByIdIn(List<Integer> ids);
}
