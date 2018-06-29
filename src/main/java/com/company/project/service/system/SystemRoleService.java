package com.company.project.service.system;
import com.company.project.model.system.SystemRole;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by madman on 2018/06/29.
 */
public interface SystemRoleService extends Service<SystemRole> {
    List<Long> findRoleIdByUserId(Long userId);
}
