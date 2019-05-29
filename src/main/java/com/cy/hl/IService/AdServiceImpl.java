package com.cy.hl.IService;

import com.cy.hl.Service.AdService;
import com.cy.hl.dao.AdRepository;
import com.cy.hl.entity.Ad;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Resource
    AdRepository adRepository ;

    @Override
    public List<Ad> findAll() {
        return adRepository.findAll();
    }

    @Override
    public void delete(int id) {
        adRepository.deleteById(id);
    }

    @Override
    public Ad save(Ad ad) {
        return adRepository.save(ad);
    }

    @Override
    public int update(String a1, String a2) {
        return adRepository.update(a1,a2);
    }

    @Override
    public String getUpToken() {
        {
             String ACCESS_KEY = "TmtsE401PKsE67SSRXeLaxHeHV8UPKGjS6jsYMjI";
             String SECRET_KEY = "t1DySjuxe9YkZWnEv1uLtN8ncFilu70q464394iZ";
            // 要上传的空间名--bucketname 也叫存储空间名，在七年里自己设置的
            //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）
             String bucketname = "pic";
            // 密钥配置
            System.out.println("初始化上传变量");
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            return auth.uploadToken(bucketname);
        }
    }

}
