package com.cy.hl.IService;

import com.cy.hl.Service.PictureService;
import com.cy.hl.dao.PictureRepository;
import com.cy.hl.entity.Picture;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureRepository pictureRepository ;

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAllDesc();
    }

    @Override
    public List<Picture> findAllBylike() {
        return pictureRepository.findAllBylike();
    }

    @Override
    public Picture save(Picture picture) {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.format(date);
        picture.setSendTime(date);
        return pictureRepository.save(picture);
    }

    @Override
    public Picture get(int id) {
        return pictureRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public int zan(int zan, int id ) {
        zan ++ ;
        return pictureRepository.update(zan,id);
    }

    @Override
    public void deleteByUid(int uid) {
        pictureRepository.deleteByUId(uid);
    }
}
