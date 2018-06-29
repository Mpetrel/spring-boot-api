package com.company.project.service.system;
import com.company.project.model.system.SystemPermit;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by madman on 2018/06/29.
 */
public interface SystemPermitService extends Service<SystemPermit> {
    List<SystemPermit> findPermitByRoleIds(List<Long> roles);
}
