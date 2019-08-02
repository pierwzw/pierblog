package com.pier.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther zhongweiwu
 * @date 2019/7/23 19:44
 */
public class FeedBack implements Serializable {
    private static final long serialVersionUID = -6342085613952033810L;

    private int id;
    private String type;
    private String title;
    private String content;
    private int solved;
    private Date createTime;
    private Date updateTime;
}
