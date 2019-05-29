package com.cy.hl.IService;

import com.cy.hl.Service.CommentService;
import com.cy.hl.dao.CommentRepository;
import com.cy.hl.entity.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentRepository commentRepository ;
    @Override
    public Comment saveComment(Comment comment) {
//        Comment comment1=new Comment();
//        comment1.setArticleId(comment.getArticleId());
//        comment1.setCommentContent(comment.getCommentContent());
//        comment1.setUserId(comment.getUserId());
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.format(date);
        comment.setCommentTime(date);
        return commentRepository.save(comment) ;
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public int zan(int zan, int commentId) {
        zan ++ ;
        return commentRepository.zan(zan,commentId);
    }

}
