package com.company.project.mapper.system;

import com.company.project.core.Mapper;
import com.company.project.model.system.SystemRole;

import java.util.List;

public interface SystemRoleMapper extends Mapper<SystemRole> {
    List<Long> findRoleIdByUserId(Long userId);
}