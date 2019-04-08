package com.cy.hl.entity;

import lombok.Builder;
import lombok.Data;

/**
 * LoginUser DTO
 */
@Data
@Builder
public class LoginUser {
    private String email;
    private String password;

    public static void main(String[] args) {
        /*
         * User user=new User();//The constructor User() is undefined
         * LoginUser loginUser = new LoginUser("aaa@qq.com", "aaa");
         */
        LoginUser loginUser=LoginUser.builder()
                .email("bbb@qq.com")
                .password("bbb")
                .build();
        System.out.println(loginUser);
    }
    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUser() {
    }
}
