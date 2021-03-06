package com.cy.hl.Service;

import com.cy.hl.entity.LoginUser;
import com.cy.hl.entity.User;
import com.cy.hl.util.ResponseUtil;

import java.util.List;

public interface UserService {
    /**
     * 获取所有user
     * @return
     */
    List<User> findAll();
    User findById(int id) ;
    User save(User user) ;
    ResponseUtil userLogin(LoginUser loginUser);
    void delete(int id) ;
    void deleteUserId( int userId) ;
    void update(String p , int id ) ;
    void updateAvatar(String avatar , int id ) ;

}
