package com.li.springboot.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import javafx.scene.control.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("houseinfo")
public class HouseInfo {
    @TableId(type = IdType.AUTO)
    @ExcelProperty("主键")
    private Long id;            //主键   自增
    @ExcelProperty("小区名称")
    private String cellName;         //    小区名称: 明阳建成小区
    @ExcelProperty("楼号")
    private Integer buildingNumber;          //    楼号: 9
    @ExcelProperty("单元号")
    private Integer unitNumber;         //    单元号: 1
    @ExcelProperty("房间号")
    private Integer roomNumber;            //    房间号: 1602
    @ExcelProperty("总价/万元")
    private Double totalPrice;           //    总价: 106
    @ExcelProperty("单价/元")
    private Integer unitPrice;           //    单价: 6000
    @ExcelProperty("户型")
    private String houseType;            //    户型: 四室两厅两卫
    @ExcelProperty("面积/平米")
    private Double area;                  //    面积: 106
    @ExcelProperty("购买方式 1是分期  2是全款")
    private Integer purchasingMethod;   //    购买方式: 分期/全款  1是分期  2是全款
    @ExcelProperty("电梯: 0是无 1是有")
    private Integer isElevator;            //    电梯: 有      0是无   1是有
    @ExcelProperty("建成年代")
    private Integer completionYear;            //    建成年代: 2012
    @ExcelProperty("供暖")
    private Integer isHeating;            //    供暖: 有       0是无    1是有
    @ExcelProperty("绿化%")
    private Integer greeningArea;            //    绿化: 38%

    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty("记录创建时间")
    private Date createTime;                      //记录创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ExcelProperty("记录更新时间")
    private Date updateTime;                      //记录更新时间
    @Version
    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty("版本号")
    private Integer version;                      //版本号  便于乐观锁  实现
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty("逻辑删除字段")
    private Integer deleted;                    //逻辑删除字段  0 未删除  1删除

    public HouseInfo(String cellName, Integer buildingNumber, Integer unitNumber, Integer roomNumber, Double totalPrice, Integer unitPrice, String houseType, Double area, Integer purchasingMethod, Integer isElevator, Integer completionYear, Integer isHeating, Integer greeningArea) {
        this.cellName = cellName;
        this.buildingNumber = buildingNumber;
        this.unitNumber = unitNumber;
        this.roomNumber = roomNumber;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
        this.houseType = houseType;
        this.area = area;
        this.purchasingMethod = purchasingMethod;
        this.isElevator = isElevator;
        this.completionYear = completionYear;
        this.isHeating = isHeating;
        this.greeningArea = greeningArea;
    }


}
