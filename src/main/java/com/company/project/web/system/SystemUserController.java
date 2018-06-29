package com.company.project.web.system;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.system.SystemUser;
import com.company.project.service.system.SystemUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by madman on 2018/06/29.
*/
@RestController
@RequestMapping("/system/user")
public class SystemUserController {
    @Resource
    private SystemUserService systemUserService;

    @PostMapping
    public Result add(@RequestBody SystemUser systemUser) {
        systemUserService.save(systemUser);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        systemUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SystemUser systemUser) {
        systemUserService.update(systemUser);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SystemUser systemUser = systemUserService.findById(id);
        return ResultGenerator.genSuccessResult(systemUser);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SystemUser> list = systemUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
