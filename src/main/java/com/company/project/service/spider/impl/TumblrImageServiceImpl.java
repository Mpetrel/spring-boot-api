package com.company.project.service.spider.impl;

import com.company.project.mapper.spider.TumblrImageMapper;
import com.company.project.model.spider.TumblrImage;
import com.company.project.service.spider.TumblrImageService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by madman on 2018/07/11.
 */
@Service
@Transactional
public class TumblrImageServiceImpl extends AbstractService<TumblrImage> implements TumblrImageService {
    @Resource
    private TumblrImageMapper tTumblrImageMapper;

}
