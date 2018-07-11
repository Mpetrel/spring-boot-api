package com.company.project.service.spider.impl;

import com.company.project.mapper.spider.TumblrUserMapper;
import com.company.project.model.spider.TumblrUser;
import com.company.project.service.spider.TumblrUserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by madman on 2018/07/11.
 */
@Service
@Transactional
public class TumblrUserServiceImpl extends AbstractService<TumblrUser> implements TumblrUserService {
    @Resource
    private TumblrUserMapper tTumblrUserMapper;

}
