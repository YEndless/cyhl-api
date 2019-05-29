package com.cy.hl.dao;

import com.cy.hl.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{
}
