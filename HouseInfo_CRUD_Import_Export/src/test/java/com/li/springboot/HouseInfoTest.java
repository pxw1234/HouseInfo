package com.li.springboot;

import com.li.springboot.entity.HouseInfo;
import com.li.springboot.mapper.HouseInfoMapper;
import com.li.springboot.service.HouseInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HouseInfoTest {

    @Autowired
    private HouseInfoService houseInfoService;

    @Autowired
    private HouseInfoMapper houseInfoMapper;

    @Test
    public void test(){
        //添加
//        final HouseInfo houseInfo = new HouseInfo("明阳建成小区",9,1,1602,106.0,6000,"四室两厅两卫",106.0,1,0,2012,0,38);
//        houseInfoService.save(houseInfo);
        //删除

        //修改

        //查询
//        final List<HouseInfo> houseInfos = houseInfoMapper.selectList(null);
//        System.out.println(houseInfos);

        final List<HouseInfo> list = houseInfoService.list(null);
        System.out.println(list.size());


    }
}
