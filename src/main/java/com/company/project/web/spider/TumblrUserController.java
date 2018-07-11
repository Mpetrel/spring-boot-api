package com.company.project.web.spider;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.spider.TumblrUser;
import com.company.project.service.spider.TumblrUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by madman on 2018/07/11.
*/
@RestController
@RequestMapping("/tumblr/user")
public class TumblrUserController {
    @Resource
    private TumblrUserService tumblrUserService;

    @PostMapping
    public Result add(@RequestBody TumblrUser tumblrUser) {
        tumblrUserService.save(tumblrUser);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        tumblrUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody TumblrUser tumblrUser) {
        tumblrUserService.update(tumblrUser);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        TumblrUser tumblrUser = tumblrUserService.findById(id);
        return ResultGenerator.genSuccessResult(tumblrUser);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TumblrUser> list = tumblrUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
