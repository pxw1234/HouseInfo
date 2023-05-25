package com.li.springboot.service.Impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.springboot.entity.HouseInfo;
import com.li.springboot.mapper.HouseInfoMapper;
import com.li.springboot.service.HouseInfoService;
import org.springframework.stereotype.Service;

@Service
public class HouseInfoServiceImpl extends ServiceImpl<HouseInfoMapper, HouseInfo> implements HouseInfoService {
}
