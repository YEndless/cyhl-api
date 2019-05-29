package com.cy.hl.Controller;

import com.cy.hl.Service.AdService;
import com.cy.hl.entity.Ad;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "ad")
@CrossOrigin
public class AdController {
    @Resource
    private AdService adService ;
    @GetMapping("/all")
    public List<Ad> findAll(){
        return adService.findAll();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer id){
        adService.delete(id);
    }
    @RequestMapping("/save")
    public Ad save(Ad ad){
        return adService.save(ad) ;
    }
    @RequestMapping("/openAddCompany")
    public ModelAndView openAddCompany(){
        ModelAndView mv=new ModelAndView();
        String accessKey = "TmtsE401PKsE67SSRXeLaxHeHV8UPKGjS6jsYMjI ";
        String secretKey = "t1DySjuxe9YkZWnEv1uLtN8ncFilu70q464394iZ";
        String bucket = "pic";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        mv.addObject("upToken",upToken);
        mv.setViewName("/addcompany.btl");
        return mv;
    }

    @RequestMapping(value = "/Uptoken", method = RequestMethod.POST)
    @ResponseBody
    public String getUptoken() {
        return adService.getUpToken();
    }
}