package com.cy.hl.IService;

import com.cy.hl.Service.LikesService;
import com.cy.hl.dao.LikesRepository;
import com.cy.hl.entity.Likes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikesServiceImpl implements LikesService {
    @Resource
    LikesRepository likesRepository ;
    @Override
    public List<Likes> findAll() {
        return likesRepository.findAll();
    }

    @Override
    public List<Likes> findByAticleidAndUserId(int article, int userid) {
        return likesRepository.findByAticleidAndUserId(article,userid);
    }

    @Override
    public void delete(Integer id) {
        likesRepository.deleteById(id);
    }

    @Override
    public Likes save(Likes likes) {
        return likesRepository.saveAndFlush(likes);
    }
}
