package com.cy.hl.Controller;

import com.cy.hl.Service.FeedbavkService;
import com.cy.hl.entity.Feedback;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "feedback")
@CrossOrigin
public class FeedbackController {
    @Resource
    private FeedbavkService feedbavkService ;

    @GetMapping("/all")
    public List<Feedback> findAll(){
        return feedbavkService.findAll();
    }

    @RequestMapping("/save")
    public Feedback save(Feedback feedback){
        return feedbavkService.save(feedback) ;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer id){
        feedbavkService.delete(id);
    }
}
