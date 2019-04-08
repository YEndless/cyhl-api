package com.cy.hl.Service;

import com.cy.hl.entity.Post;

public interface PostService {
    Post getPostById(Long id);;

    void readingIncrease(Long id);
}
