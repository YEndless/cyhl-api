package com.cy.hl.IService;

import com.cy.hl.Service.CommentService;
import com.cy.hl.dao.CommentRepository;
import com.cy.hl.dao.PostRepository;
import com.cy.hl.entity.Comment;
import com.cy.hl.entity.Post;
import com.cy.hl.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentRepository commentRepository ;

    @Resource
    private PostRepository postRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    @Transactional
    public void removeComment(Long id) {
        commentRepository.deleteById(id);
    }
    @Override
    public Integer countCommentSizeByPost(Post post) {
        return commentRepository.countByPost(post);
    }
    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).get();
    }
    @Override
    public void createComment(Long postId, String commentContent) {
        Post post = postRepository.findById(postId).get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment = new Comment(user, post, commentContent);
        commentRepository.save(comment);
    }
    @Override
    public void replyComment(Long postId, Long commentId, Long replyId, String commentContent) {
        Post post = postRepository.findById(postId).get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment = new Comment(user, post, commentId, commentContent);
        //评论回复，需要加上@用户
        if (replyId != null) {
            Comment replyComment = commentRepository.findById(replyId).get();
            comment.setReplyUser(replyComment.getUser());
        }
        //添加评论
        commentRepository.save(comment);
    }

}
