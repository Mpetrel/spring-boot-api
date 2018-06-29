package com.company.project.web;


import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import com.company.project.model.system.SystemUser;
import com.company.project.service.system.SystemUserService;
import com.company.project.util.JWTUtil;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/")
public class IndexController {

    @Resource
    private SystemUserService systemUserService;

    @PostMapping(value = "/auth/login")
    public Result login(String userName, String password) {

        if (!Strings.isNullOrEmpty(password)) {
            SystemUser user = systemUserService.findBy("loginName", userName);
            // 对password进行加密
            String passwordHash = Hashing.sha256().hashBytes(password.concat(user.getSalt()).getBytes()).toString();
            if (user.getPassword().equals(passwordHash)) {
                // 生成token
                JSONObject data = new JSONObject();
                data.put("token", JWTUtil.sign(user.getLoginName(), user.getPassword()));
                return ResultGenerator.genSuccessResult(data);
            }
        }
        return ResultGenerator.genFailResult("用户名或密码错误");
    }


    /**
     * 未授权返回
     * @return
     */
    @GetMapping(value = "/auth/unauthorized")
    public Result unauthorized() {
        Result result = new Result();
        result.setCode(ResultCode.UNAUTHORIZED);
        result.setMessage("invalid token");
        return result;
    }



}
