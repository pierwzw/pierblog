package com.pier.controller;


import com.pier.entity.Tag;
import com.pier.service.ArticleService;
import com.pier.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @author pierwzw
 */
@Controller
@RequestMapping("/admin")
public class SimEditorController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    /**
     * 后台标签列表显示
     * @return
     */
    @RequestMapping(value = "/sim")
    public ModelAndView index()  {
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("Admin/Article/sim");
        return modelandview;
    }
}
