package com.company.project.mapper.system;

import com.company.project.core.Mapper;
import com.company.project.model.system.SystemPermit;

import java.util.List;

public interface SystemPermitMapper extends Mapper<SystemPermit> {
    List<SystemPermit> findPermitByRoleIds(List<Long> roles);
}