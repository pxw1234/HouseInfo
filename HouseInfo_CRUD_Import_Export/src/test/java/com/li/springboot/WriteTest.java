package com.li.springboot;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.li.springboot.entity.HouseInfo;
import com.li.springboot.lister.ReadExcelLister;
import com.li.springboot.service.HouseInfoService;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class WriteTest {
    @Autowired
    private HouseInfoService houseInfoService;

    @Test
    public void simpleWrite(){
        String fileName = WriteTest.class.getResource("/").getPath()+"simpleWrite" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        final List<HouseInfo> list = houseInfoService.list();
        EasyExcel.write(fileName, HouseInfo.class).sheet("模板").doWrite(list);
    }

    @Test
    public void simpleRead(){

        String fileName = "E:/0_myself/Java/spring_boot/HouseInfo_CRUD_Import_Export/target/test-classes/simpleWrite1685001313105.xlsx";
        final ArrayList<HouseInfo> houseInfolists = new ArrayList<>();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, HouseInfo.class, new PageReadListener<HouseInfo>(dataList -> {
            for (HouseInfo houseInfo : dataList) {
                log.info("读取到一条数据{}", houseInfo.toString());
                houseInfolists.add(houseInfo);
            }
        })).sheet().doRead();
        houseInfoService.saveBatch(houseInfolists);
    }
}
