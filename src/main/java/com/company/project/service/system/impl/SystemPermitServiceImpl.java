package com.company.project.service.system.impl;

import com.company.project.mapper.system.SystemPermitMapper;
import com.company.project.model.system.SystemPermit;
import com.company.project.service.system.SystemPermitService;
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
public class SystemPermitServiceImpl extends AbstractService<SystemPermit> implements SystemPermitService {
    @Resource
    private SystemPermitMapper tSystemPermitMapper;

    @Override
    public List<SystemPermit> findPermitByRoleIds(List<Long> roles) {
        return tSystemPermitMapper.findPermitByRoleIds(roles);
    }
}
