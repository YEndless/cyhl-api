package com.cy.hl.Controller;

import com.cy.hl.Service.PictureService;
import com.cy.hl.entity.Picture;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/picture")
@CrossOrigin
public class PictureController {
    @Resource
    private PictureService pictureService ;

    @GetMapping("/all")
    public List<Picture> findAll(){
        return pictureService.findAll();
    }

    @GetMapping("/allByLike")
    public List<Picture> findAllByLike(){
        return pictureService.findAllBylike();
    }

    @GetMapping("/{id}")
    public Picture getPicture(@PathVariable int id){
        return pictureService.get(id) ;
    }

    @RequestMapping("/save")
    public Picture save(Picture picture){
        return pictureService.save(picture) ;
    }

    @RequestMapping (value = "/delete1",method = RequestMethod.DELETE)
    public void delete(@RequestParam Integer id){
        pictureService.delete(id);
    }

    @GetMapping("/deleteByUId")
    public void deleteByUserId(int userId){
        pictureService.deleteByUid(userId);
    }


    @RequestMapping(value = "/zan" )
    public @ResponseBody
    int zan(@RequestParam("zan") int zan,@RequestParam("id") Integer id) {
        return pictureService.zan(zan,id );
    }

}
