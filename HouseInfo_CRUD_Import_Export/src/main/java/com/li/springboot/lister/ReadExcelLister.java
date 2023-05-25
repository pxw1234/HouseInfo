package com.li.springboot.lister;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.li.springboot.entity.HouseInfo;
import com.li.springboot.service.HouseInfoService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class ReadExcelLister implements ReadListener<HouseInfo> {

    /**
      * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    private HouseInfoService houseInfoService;

    /**
     * 缓存的数据
     */
    private List<HouseInfo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ReadExcelLister(HouseInfoService houseInfoService) {
        this.houseInfoService = houseInfoService;
    }

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(HouseInfo houseInfo, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", houseInfo.toString());
        cachedDataList.add(houseInfo);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        houseInfoService.saveBatch(cachedDataList);
        log.info("存储数据库成功！");
    }
}
