package com.cy.hl.IService;

import com.cy.hl.Service.FeedbavkService;
import com.cy.hl.dao.FeedbackRepository;
import com.cy.hl.entity.Feedback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FeedbavkServiceImpl implements FeedbavkService {
    @Resource
    private FeedbackRepository feedbackRepository ;

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback save(Feedback feedback) {
        Date date = new Date() ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        simpleDateFormat.format(date) ;
        feedback.setSendTime(date);
        return feedbackRepository.save(feedback);
    }

    @Override
    public void delete(int id) {
        feedbackRepository.deleteById(id);
    }


}
