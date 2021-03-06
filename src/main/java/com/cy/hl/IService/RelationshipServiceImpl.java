package com.cy.hl.IService;

import com.cy.hl.Service.RelationshipService;
import com.cy.hl.dao.RelationshipRepository;
import com.cy.hl.dao.UserRepository;
import com.cy.hl.entity.Relationship;
import com.cy.hl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    private RelationshipRepository relationshipRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Page<User> listFollows(Integer userId, Pageable pageable) {
        List<Integer> relationshipList = relationshipRepository.findByFromUserId(userId);
        Page<User> userPage = userRepository.findByIdIn(relationshipList, pageable);
        return userPage;
    }
    @Override
    public Page<User> listFans(Integer userId, Pageable pageable) {
        List<Integer> relationshipList = relationshipRepository.findByToUserId(userId);
        Page<User> userPage = userRepository.findByIdIn(relationshipList, pageable);
        return userPage;
    }
    @Override
    public List<Integer> listFriends(Integer userId) {
        List<Integer> relationshipList = relationshipRepository.findFriendsByUserId(userId);
//        List<User> userList = userRepository.findByIdIn(relationshipList);
        return relationshipList;
    }
    @Override
    public void saveRelationship(Relationship relationship) {
        //添加关注
        relationshipRepository.save(relationship);
        //更新双方关注数和粉丝数
        updateFollowSize(relationship.getFromUserId());
        updateFanSize(relationship.getToUserId());
    }
    @Override
    public void removeRelationship(Relationship relationship) {
        //删除关系
        relationshipRepository.delete(relationship);
        //更新双方关注数和粉丝数
        updateFollowSize(relationship.getFromUserId());
        updateFanSize(relationship.getToUserId());
    }
    @Override
    public void updateFollowSize(Integer userId) {
        User user = userRepository.findById(userId).get();
//        user.setFollowSize(relationshipRepository.countByFromUserId(userId));
        userRepository.save(user);
    }
    @Override
    public void updateFanSize(Integer userId) {
        User user = userRepository.findById(userId).get();
//        user.setFanSize(relationshipRepository.countByToUserId(userId));
        userRepository.save(user);
    }
}
