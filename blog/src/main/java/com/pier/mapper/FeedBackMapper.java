package com.pier.mapper;

import com.pier.entity.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pierwzw
 */

public interface FeedBackMapper {

    /**
     * 添加
     * @param type 类型
     * @param title 标题
     * @param content 内容
     * @return 行数
     */
    int insert(@Param("type") String type, @Param("title") String title, @Param("content") String content);
}