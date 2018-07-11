package com.company.project.service.spider.impl;

import com.company.project.mapper.spider.TumblrBlogMapper;
import com.company.project.model.spider.TumblrBlog;
import com.company.project.service.spider.TumblrBlogService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by madman on 2018/07/11.
 */
@Service
@Transactional
public class TumblrBlogServiceImpl extends AbstractService<TumblrBlog> implements TumblrBlogService {
    @Resource
    private TumblrBlogMapper tTumblrBlogMapper;

}
