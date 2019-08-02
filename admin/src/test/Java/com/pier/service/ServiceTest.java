package com.pier.service;

import com.pier.entity.Article;
import com.pier.mapper.ArticleCategoryRefMapper;
import com.pier.mapper.ArticleMapper;
import com.pier.mapper.ArticleTagRefMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther zhongweiwu
 * @date 2019/7/23 20:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-admin-context.xml"})
public class ServiceTest {

    @Test
    public void Test(){
        String str = "../../hfklsdfas";
        str=str.replaceAll("\\.\\./\\.\\.", "");
        System.out.println(str);
    }

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleTagRefMapper articleTagRefMapper;

    @Autowired
    ArticleCategoryRefMapper articleCategoryRefMapper;

    @Test
    public void test(){
        for (int i=1; i<=58; i++){
            Article article = articleService.getArticleByStatusAndId(1, i);
            if (article==null){
                articleTagRefMapper.deleteByArticleId(i);
                articleCategoryRefMapper.deleteByArticleId(i);
            }
        }
    }
}