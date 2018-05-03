package com.company.project.service.system.impl;

import com.company.project.mapper.system.SystemUserMapper;
import com.company.project.model.system.SystemUser;
import com.company.project.service.system.SystemUserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by madman on 2018/05/03.
 */
@Service
@Transactional
public class SystemUserServiceImpl extends AbstractService<SystemUser> implements SystemUserService {
    @Resource
    private SystemUserMapper tmSystemUserMapper;

}
