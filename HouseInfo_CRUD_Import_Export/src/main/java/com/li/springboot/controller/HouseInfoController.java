package com.li.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.li.springboot.entity.HouseInfo;
import com.li.springboot.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/houseinfo")
public class HouseInfoController {

    @Autowired
    private HouseInfoService houseInfoService;

    @RequestMapping
    public String index(Model model){
        final List<HouseInfo> list = houseInfoService.list();
        model.addAttribute("houseInfoList",list);
        return "houseinfos";
    }

    @RequestMapping("/delete/{id}")
    public String deleteHouseInfo(@PathVariable("id") Long id){
        houseInfoService.removeById(id);
        System.out.println(id);
        return "redirect:/houseinfo";
    }

    @RequestMapping("/toedit/{id}")
    public String toEditHouseInfo(@PathVariable("id") Long id,Model model){
        final HouseInfo houseInfo = houseInfoService.getById(id);
        model.addAttribute("houseinfo",houseInfo);
        return "edithouseinfo";
    }

    @RequestMapping("/edit")
    public String editHouseInfo(HouseInfo houseInfo,Model model){
        System.out.println(houseInfo);
        houseInfoService.updateById(houseInfo);
//        model.addAttribute("houseinfo",houseInfo);
        return "redirect:/houseinfo";
    }
    @RequestMapping("/toadd")
    public String toAddHouseInfo(HouseInfo houseInfo){
        return "addhouseinfo";
    }
    @RequestMapping("/add")
    public String addHouseInfo(HouseInfo houseInfo){
        houseInfoService.save(houseInfo);
        return "redirect:/houseinfo";
    }

    //下载
    @RequestMapping("/export")
    public ResponseEntity excelExport(HttpServletResponse response) throws IOException {
        //导出excel
        String fileName = HouseInfoController.class.getResource("/").getPath()+"houseInfo" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        final List<HouseInfo> list = houseInfoService.list();
        EasyExcel.write(fileName, HouseInfo.class).sheet("房源信息").doWrite(list);

        //下载
        //创建输入流
        final FileInputStream fileInputStream = new FileInputStream(fileName);
        //创建字节数组
        final byte[] bytes = new byte[fileInputStream.available()];

//        将流读入到字节数组中
        fileInputStream.read(bytes);
        //创建httpheader对象 设置响应头信息
        final HttpHeaders httpHeaders = new HttpHeaders();
        //设置下载方式及下载文件的名字【文件格式为附件格式，通知服务器下载当前资源而不是打开】
        httpHeaders.add("Content-Disposition", "attachment;filename="+fileName);
        //处理中文文件名的问题
        httpHeaders.setContentDispositionFormData("attachment",new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
        //设置状态响应码
        final HttpStatus ok = HttpStatus.OK;
        //创建responseentity 对象
        final ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,httpHeaders,ok);
        fileInputStream.close();
        return responseEntity;
    }



    //上传
    @RequestMapping("/import")
    public void fileupload(String username, MultipartFile fileupload, HttpSession session) throws IOException {

//      将type=file【文件域】直接入参：MultipartFile类型即可
//      获取文件名称
        String fileName = fileupload.getOriginalFilename();
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
//      获取上传文件真实路径

        String realPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/upload";
        //如果文件夹不存在  就创建
        final File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        System.out.println("realPath="+realPath);

        String filepath = realPath + File.separator+fileName;
//      实现文件上传
        fileupload.transferTo(new File(filepath));

        //文件读取

    }





}
