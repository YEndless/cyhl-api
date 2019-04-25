package com.cy.hl.IService;

import com.cy.hl.Service.UserService;
import com.cy.hl.dao.UserRepository;
import com.cy.hl.entity.LoginUser;
import com.cy.hl.entity.User;
import com.cy.hl.vo.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseUtil userLogin(LoginUser loginUser) {
        User user = userRepository.findUserByEmail(loginUser.getEmail());
        //邮箱有效
        if (user != null) {
            //判断密码是否正确
            if (loginUser.getPassword().equals(user.getPassword())) {
                return new ResponseUtil(0, "login success", user);
            } else {
                return new ResponseUtil(0, "password wrong");
            }
        } else {
            return new ResponseUtil(0, "email wrong");
        }
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUserId(int userId) {
        userRepository.deleteById(userId);
    }

}
