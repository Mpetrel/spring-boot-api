package com.company.project.web;


import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.system.SystemUser;
import com.company.project.service.system.SystemUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/")
public class IndexController {

    @Resource
    private SystemUserService systemUserService;

    @PostMapping(value = "/auth/login")
    public Result login(String userName, String password) {
        SystemUser user = systemUserService.findBy("loginName", userName);
        if (user.getPassword().equals(password)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("用户名或密码错误");
    }




}
