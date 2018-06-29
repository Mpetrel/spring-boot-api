package com.company.project.auth;

import com.company.project.model.system.SystemPermit;
import com.company.project.model.system.SystemUser;
import com.company.project.service.system.SystemPermitService;
import com.company.project.service.system.SystemRoleService;
import com.company.project.service.system.SystemUserService;
import com.company.project.util.JWTUtil;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/05
 * Time: 16:53
 * shiro realm
 */
@Slf4j
public class SystemShiroRealm extends AuthorizingRealm {
    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private SystemRoleService systemRoleService;
    @Autowired
    private SystemPermitService systemPermitService;

    /**
     * 设定支持验证的token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JWTUtil.getUsername(principalCollection.toString());
        SystemUser user = systemUserService.findBy("userName", username);
        //查询用户角色和权限
        List<Long> roles = systemRoleService.findRoleIdByUserId(user.getId());
        List<SystemPermit> permits = systemPermitService.findPermitByRoleIds(roles);

        //转换为String
        List<String> roleStr = Lists.transform(roles, Functions.toStringFunction());
        //添加角色
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleStr);
        //添加权限
        if( permits != null && !permits.isEmpty()){
            permits.forEach((permit) -> simpleAuthorizationInfo.addStringPermission(permit.getUrl()));
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("invalid token");
        }
        SystemUser userBean = systemUserService.findBy("loginName", username);
        if (userBean == null) {
            throw new AuthenticationException("invalid token");
        }
        if (! JWTUtil.verify(token, username, userBean.getPassword())) {
            throw new AuthenticationException("invalid token");
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }
}
