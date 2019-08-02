package com.pier.controller;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

    public static final String filepath = "/root/webapps/file";

    @RequestMapping(value = "/fileUpload")
    public String testUpload(HttpServletRequest request, @RequestParam("file") CommonsMultipartFile file) {
        out.println("realPath :" + filepath);
        File file1 = new File(filepath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File(filepath + "/"+ fileName));
        } catch (Exception e) {
            log.error("upload file error", e);
            request.setAttribute("errorMsg", e.getMessage());
            return "error";
        }
        return "FileUpAndDown";
    }
}