package com.company.project.service.system.impl;

import com.company.project.mapper.system.SystemRoleMapper;
import com.company.project.model.system.SystemRole;
import com.company.project.service.system.SystemRoleService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by madman on 2018/06/29.
 */
@Service
@Transactional
public class SystemRoleServiceImpl extends AbstractService<SystemRole> implements SystemRoleService {
    @Resource
    private SystemRoleMapper tSystemRoleMapper;

    @Override
    public List<Long> findRoleIdByUserId(Long userId) {
        return tSystemRoleMapper.findRoleIdByUserId(userId);
    }
}
