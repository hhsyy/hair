package com.it.hair.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.hair.entity.Haircut;
import com.it.hair.mapper.HaircutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class HairCutController {

    @Autowired
    private HaircutMapper haircutMapper;

    @RequestMapping("/addByid")
    @ResponseBody
    public  int addByid(Haircut haircut) {
        try {
            if(haircut.getDate1()==null||haircut.getDate2()==null||haircut.getGh()==null||haircut.getXm()==null||haircut.getBm()==null||haircut.getSj()==null){
                return 4;
            }

            QueryWrapper<Haircut> wrapper1 = new QueryWrapper<Haircut>();
            QueryWrapper<Haircut> wrapper2 = new QueryWrapper<Haircut>();
            //gai日知否注册
            wrapper1.eq("date1",haircut.getDate1());
            wrapper1.eq("gh",haircut.getGh());
            Haircut haircut1 = haircutMapper.selectOne(wrapper1);
            if (haircut1!=null){
                return 2;
            }

            //gai时间段是否注册
            wrapper2.eq("date1",haircut.getDate1());
            wrapper2.eq("date2",haircut.getDate2());
            Haircut haircut2 = haircutMapper.selectOne(wrapper2);
            if (haircut2!=null){
                return 3;
            }

            int insert = haircutMapper.insert(haircut);
            if(insert<=0){
                throw new Exception();
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @RequestMapping("/findByGh")
    @ResponseBody
    public   List<Haircut> findByGh(Integer gh) {
        List<Haircut> haircuts = null;
        try {

            if(gh == null){
                    throw new Exception();
            }

            QueryWrapper<Haircut> wrapper = new QueryWrapper<Haircut>();
            wrapper.eq("gh",gh);
            haircuts = haircutMapper.selectList(wrapper);
            if(haircuts==null){
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
        return haircuts;
    }

    @RequestMapping("/delByGh")
    @ResponseBody
    public  int delByGh(String gh,String date1) {
        try {
            if(gh == null || date1 == null){
                return 4;
            }
            QueryWrapper<Haircut> wrapper = new QueryWrapper<Haircut>();
            wrapper.eq("gh", gh);
            wrapper.eq("date1", date1);
            int delete = haircutMapper.delete(wrapper);
            if(delete<=0){
                throw new Exception();
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @RequestMapping("/getListByDate")
    @ResponseBody
    public  List<Haircut> getListByDate(String date1) {
        List<Haircut> haircuts = null;
        try {
            if(date1 == null){
                throw new Exception();
            }
            QueryWrapper<Haircut> wrapper = new QueryWrapper<Haircut>();
            wrapper.eq("date1", date1);
            haircuts = haircutMapper.selectList(wrapper);
            if(haircuts == null){
                throw new Exception();
            }
        } catch (Exception e) {
            return null;
        }
        return haircuts;
    }


}
