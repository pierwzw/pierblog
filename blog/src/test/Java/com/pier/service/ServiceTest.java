package com.pier.service;

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
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class ServiceTest {

    @Autowired
    FeedBackService feedBackService;

    @Test
    public void Test(){
        feedBackService.insert("feed", "haha", "haha");
    }

}