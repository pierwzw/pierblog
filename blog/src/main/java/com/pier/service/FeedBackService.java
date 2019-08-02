package com.pier.service;

import com.pier.entity.Link;

import java.util.List;

/**
 *
 * @author pierwzw
 * @date 2019/7/23
 */
public interface FeedBackService {

    /**
     * 插入反馈
     * @param type 类型
     * @param title 标题
     * @param content 内容
     * @return 行数
     */
    int insert(String type, String title, String content);
}
