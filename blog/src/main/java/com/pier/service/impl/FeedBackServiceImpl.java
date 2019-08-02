package com.pier.service.impl;

import com.pier.entity.Link;
import com.pier.mapper.FeedBackMapper;
import com.pier.mapper.LinkMapper;
import com.pier.service.FeedBackService;
import com.pier.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author pierwzw
 * @date 2017/9/4
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
	
	@Autowired
	private FeedBackMapper feedBackMapper;

	@Override
	public int insert(String type, String title, String content) {
		return feedBackMapper.insert(type, title, content);
	}
}
