package com.pier.controller;

import cn.hutool.core.collection.CollUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * 必须在server.xml中设置utf-8转码
 * @auther zhongweiwu
 * @date 2019/3/21 11:56
 */
@Controller
public class FileController {

    private Logger log = Logger.getLogger(this.getClass());

    public static final String filepath = "/root/webapps/assets/upload";

    @RequestMapping(value = "/fileUpload", method= RequestMethod.POST)
    @ResponseBody
    public Map testUpload(@RequestParam("file") CommonsMultipartFile file) {
        /*out.println("realPath :" + filepath);*/
        File file1 = new File(filepath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        String fileName = file.getOriginalFilename();
        Map<String, Object> map = new HashMap<>();
        String absolutePath = filepath + "/" + fileName;
        map.put("location", "/upload/" + fileName);
        try {
            file.transferTo(new File(absolutePath));
            map.put("success", true);
            map.put("msg", "upload success");
        } catch (Exception e) {
            log.error("upload file error", e);
            map.put("success", false);
            map.put("msg", "upload failed");
        }
        return map;
    }
}