package com.pier.controller;


import com.alibaba.fastjson.JSON;
import com.pier.entity.*;
import com.pier.enums.ArticleStatus;
import com.pier.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 反馈建议的controller
 *
 * @author pierwzw
 * @date 2019/7/23
 */
@Controller
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    /**
     * 增加反馈
     * @param type
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "/feedback")
    @ResponseBody
    public void addFeedBack(@RequestParam String type,
                              @RequestParam String title,
                              @RequestParam String content) {
        feedBackService.insert(type, title, content);
    }
}
