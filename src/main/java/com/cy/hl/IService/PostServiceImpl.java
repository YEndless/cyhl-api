package com.cy.hl.IService;

import com.cy.hl.Service.PostService;
import com.cy.hl.dao.PostRepository;
import com.cy.hl.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    PostRepository postRepository ;

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).get() ;
    }

    @Override
    public void readingIncrease(Long id) {

    }
}
