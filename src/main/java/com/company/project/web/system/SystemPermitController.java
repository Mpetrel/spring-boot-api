package com.company.project.web.system;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.system.SystemPermit;
import com.company.project.service.system.SystemPermitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by madman on 2018/06/29.
*/
@RestController
@RequestMapping("/admin/system/permit")
public class SystemPermitController {
    @Resource
    private SystemPermitService systemPermitService;

    @PostMapping
    public Result add(@RequestBody SystemPermit systemPermit) {
        systemPermitService.save(systemPermit);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        systemPermitService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SystemPermit systemPermit) {
        systemPermitService.update(systemPermit);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SystemPermit systemPermit = systemPermitService.findById(id);
        return ResultGenerator.genSuccessResult(systemPermit);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SystemPermit> list = systemPermitService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    public Result userPermit() {
        SecurityUtils.getSubject();
        return null;
    }


}
